package cn.lailab.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͳ����������ı����ַ���,��Ӧ�ı����ַ���,��Ӧ��MIME����(���������������)
 * Servlet Filter implementation class CharacterEncoding
 */
@WebFilter(urlPatterns="/*" ,initParams={@WebInitParam(name="character",value="utf-8")})
public class CharacterEncoding implements Filter {
	//�洢��ǰ���ַ���
	private String curCharacter;

	/**
	 * �������������ٵ�ʱ��,ִ��destroy����
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("CharacterEncodingʵ����������...");
	}

	/**
	 * ���˹���
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�жϵ�ǰ���ַ�����Ϊ�յ������
		if(curCharacter!=null){
			//ServletRequest ->HttpServletRequest
			//ctrl+shift+o:�����
			HttpServletRequest req=(HttpServletRequest)request;
			//��������ı����ַ���
			req.setCharacterEncoding(curCharacter);
			//ServletResponse ->HttpServletResponse
			HttpServletResponse resp=(HttpServletResponse)response;
			//������Ӧ�ı����ַ���
			resp.setCharacterEncoding(curCharacter);
			//������Ӧ��MIME����
			resp.setContentType("text/html;charset="+curCharacter);
			
		}
		//ִ����һ��������
		chain.doFilter(request, response);
	}

	/**
	 * ���������������ʱ��,ִ��init����
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CharacterEncodingʵ����������...");
		//���õ�ǰ���ַ���
		curCharacter=fConfig.getInitParameter("character");
	}

}
