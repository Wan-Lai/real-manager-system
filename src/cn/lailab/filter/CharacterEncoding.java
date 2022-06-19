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
 * 统计设置请求的编码字符集,响应的编码字符集,响应的MIME类型(不会出现乱码的情况)
 * Servlet Filter implementation class CharacterEncoding
 */
@WebFilter(urlPatterns="/*" ,initParams={@WebInitParam(name="character",value="utf-8")})
public class CharacterEncoding implements Filter {
	//存储当前的字符集
	private String curCharacter;

	/**
	 * 过滤器对象被销毁的时候,执行destroy方法
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("CharacterEncoding实例被销毁了...");
	}

	/**
	 * 过滤过程
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断当前的字符集不为空的情况下
		if(curCharacter!=null){
			//ServletRequest ->HttpServletRequest
			//ctrl+shift+o:导入包
			HttpServletRequest req=(HttpServletRequest)request;
			//设置请求的编码字符集
			req.setCharacterEncoding(curCharacter);
			//ServletResponse ->HttpServletResponse
			HttpServletResponse resp=(HttpServletResponse)response;
			//设置响应的编码字符集
			resp.setCharacterEncoding(curCharacter);
			//设置响应的MIME类型
			resp.setContentType("text/html;charset="+curCharacter);
			
		}
		//执行下一个过滤器
		chain.doFilter(request, response);
	}

	/**
	 * 创建过滤器对象的时候,执行init方法
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CharacterEncoding实例被创建了...");
		//设置当前的字符集
		curCharacter=fConfig.getInitParameter("character");
	}

}
