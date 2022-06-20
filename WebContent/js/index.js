

window.onload = function() {
	// 默认查看员工
	changeEmployee();

}
// 查看员工信息
function changeEmployee() {
	var show_table = document.getElementById("data_table");
	MyAjax("employee", "queryAll", function(result) {
		var rst = result2employee(result);
		console.log(rst);
		show_table.innerHTML = rst;
	});
}
// 查看顾客信息
function changeCustomer() { 
	var show_table = document.getElementById("data_table");
	MyAjax("customer", "queryAll", function(result) {
		show_table.innerHTML = result2customer(result);
	});
}
// 查看账单信息
function changeFinance() {
	var show_table = document.getElementById("data_table");
	MyAjax("finance", "queryAll", function(result) {
		show_table.innerHTML = result2finance(result);
	});
}
// 查看楼盘信息
function changeHouse() {
	var show_table = document.getElementById("data_table");
	MyAjax("house", "queryAll", function(result) {
		show_table.innerHTML = result2house(result);
	});
}
// 自定义Ajax
function MyAjax(entity, operate, callback) {
	var service;
	var operate;
	switch (entity) {
		// 若为员工
		case "employee":
			service = "EmployeeService";
			// 判断操作
			switch(operate) {
			// 查询员工
			case "queryAll":
				operate = "queryAll";
				break;
			}
			break;
		// 若为顾客
		case "customer" :
			service = "CustomerService";
			// 判断操作
			switch(operate) {
			// 查询员工
			case "queryAll":
				operate = "queryAll";
				break;
			}
			break;
		// 若为账单
		case "finance" :
			service = "FinanceService";
			// 判断操作
			switch(operate) {
			// 查询员工
			case "queryAll":
				operate = "queryAll";
				break;
			}
			break;
			// 若为楼盘
		case "house" :
			service = "HouseService";
			// 判断操作
			switch(operate) {
			// 查询员工
			case "queryAll":
				operate = "queryAll";
				break;
			}
			break;
	}
	$.ajax({
		url : "./" + service + "?operate=" + operate,
		method : "post",
		success : function(result) {
			callback(result);
		}
	});
}

// 将Ajax返回值转换成Employee对象
function result2employee(result) {
	result = eval("(" + result + ")").message;
	console.log(result);
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='javascript:document.getElementsByClassName(\"dialog-reginster-employee\")[0].style.display=\"block\"' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=5><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"employee\")'/></td>";
	str += "</tr>";
	str += "<tr>";
	str += "<th><input type='checkbox' name='checkname' id='fcheckbox' onclick='checkAll(this)'/></th>";
	str += "<th onclick='changeOrder(this,\"employee\")'>编号</th>";
	str += "<th>姓名</th>";
	str += "<th>用户名</th>";
	str += "<th>性别</th>";
	str += "<th>年龄</th>";
	str += "<th>电话</th>";
	str += "<th>部门</th>";
	str += "<th>职位</th>";
	str += "<th>薪水</th>";
	str += "</tr>";
	if (result != null) {
		if (result.length) {
			for (var i = 0; i < result.length; i++) {
				var emp = result[i];
				var id = emp.id;
				var name = emp.name;
				var username = emp.username;
				var gender = emp.gender;
				var age = emp.age;
				var phone = emp.phone;
				var department = emp.dapartment;
				var position = emp.position;
				var salary = emp.salary;
				str += "<tr>";
				str += "<td><input type='checkbox' name='checkname' class='scheckbox' lang='"
						+ id + "'/></td>"
				str += "<td>" + name + "</td>";
				str += "<td>" + username + "</td>";
				str += "<td>" + gender + "</td>";
				str += "<td>" + age + "</td>";
				str += "<td>" + phone + "</td>";
				str += "<td>" + department + "</td>";
				str += "<td>" + position + "</td>";
				str += "<td>" + salary + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteEmployee("
						+ id
						+ ")'/><input type='button' value='修改' onclick='modifyEmployee(\""
						+ name + "\")'/></td>";
				str += "</tr>";
			}
		} else {
			str += "<tr>";
			str += "<td><input type='checkbox' name='checkname'/></td>";
			str += "<td>" + result.id + "</td>";
			str += "<td>" + result.name + "</td>";
			str += "<td>" + result.username + "</td>";
			str += "<td>" + result.gender + "</td>";
			str += "<td>" + result.age + "</td>";
			str += "<td>" + result.phone + "</td>";
			str += "<td>" + result.department + "</td>";
			str += "<td>" + result.position + "</td>";
			str += "<td>" + result.salary + "</td>";
			str += "<td><input type='button' value='删除' onclick='deleteEmployee("
					+ id
					+ ")'/><input type='button' value='修改' onclick='modifyEmployee("
					+ name + ")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=9><ul>";
		str += "<td></td>";
		str += "</tr>";
	}
	return str;
}
//将Ajax返回值转换成Customer对象
function result2customer(result) {
	result = eval("(" + result + ")").message;
	console.log(result);
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='javascript:document.getElementsByClassName(\"dialog-reginster-employee\")[0].style.display=\"block\"' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=5><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"employee\")'/></td>";
	str += "</tr>";
	str += "<tr>";
	str += "<th><input type='checkbox' name='checkname' id='fcheckbox' onclick='checkAll(this)'/></th>";
	str += "<th onclick='changeOrder(this,\"employee\")'>编号</th>";
	str += "<th>姓名</th>";
	str += "<th>地址</th>";
	str += "<th>购买地址</th>";
	str += "<th>电话</th>";
	str += "<th>身份证号</th>";
	str += "<th>身份证状态</th>";
	str += "<th>登记时间</th>";
	str += "<th>希望类型</th>";
	str += "<th>备注</th>";
	str += "</tr>";
	if (result != null) {
		if (result.length) {
			for (var i = 0; i < result.length; i++) {
				var cus = result[i];
				var id = cus.id;
				var name = cus.name;
				var address = cus.address;
				var buyaddress = cus.buyaddress;
				var phone = cus.phone;
				var idnum = cus.idnum;
				var idstatu = cus.idstatu;
				var time = cus.time;
				var wanttype = cus.wanttype;
				var commend = cus.commend;
				str += "<tr>";
				str += "<td><input type='checkbox' name='checkname' class='scheckbox' lang='"
						+ id + "'/></td>"
				str += "<td>" + name + "</td>";
				str += "<td>" + address + "</td>";
				str += "<td>" + buyaddress + "</td>";
				str += "<td>" + phone + "</td>";
				str += "<td>" + idnum + "</td>";
				str += "<td>" + idstatu + "</td>";
				str += "<td>" + time + "</td>";
				str += "<td>" + wanttype + "</td>";
				str += "<td>" + commend + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteEmployee("
						+ id
						+ ")'/><input type='button' value='修改' onclick='modifyEmployee(\""
						+ name + "\")'/></td>";
				str += "</tr>";
			}
		} else {
			str += "<tr>";
			str += "<td><input type='checkbox' name='checkname'/></td>";
			str += "<td>" + result.id + "</td>";
			str += "<td>" + result.name + "</td>";
			str += "<td>" + result.address + "</td>";
			str += "<td>" + result.buyaddress + "</td>";
			str += "<td>" + result.phone + "</td>";
			str += "<td>" + result.idnum + "</td>";
			str += "<td>" + result.idstatu + "</td>";
			str += "<td>" + result.time + "</td>";
			str += "<td>" + result.wanttype + "</td>";
			str += "<td>" + result.commend + "</td>";
			str += "<td><input type='button' value='删除' onclick='deleteEmployee("
					+ id
					+ ")'/><input type='button' value='修改' onclick='modifyEmployee("
					+ name + ")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=9><ul>";
		str += "<td></td>";
		str += "</tr>";
	}
	return str;
}
//将Ajax返回值转换成Finance对象
function result2finance(result) {
	result = eval("(" + result + ")").message;
	console.log(result);
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='javascript:document.getElementsByClassName(\"dialog-reginster-employee\")[0].style.display=\"block\"' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=5><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"employee\")'/></td>";
	str += "</tr>";
	str += "<tr>";
	str += "<th><input type='checkbox' name='checkname' id='fcheckbox' onclick='checkAll(this)'/></th>";
	str += "<th>顾客ID</th>";
	str += "<th>员工ID</th>";
	str += "<th>账单金额</th>";
	str += "<th>付款方式</th>";
	str += "<th>财务类型</th>";
	str += "<th>财务时间</th>";
	str += "<th>操作</th>"
	str += "</tr>";
	if (result != null) {
		if (result.length) {
			for (var i = 0; i < result.length; i++) {
				var fin = result[i];
				var cid = fin.cid;
				var eid = fin.eid;
				var price = fin.price;
				var paymentway = fin.paymentway;
				var type = fin.type;
				var time = fin.time;
				str += "<tr>";
				str += "<th><input type='checkbox' name='checkname' id='fcheckbox' onclick='checkAll(this)'/></th>";
				str += "<td>" + cid + "</td>";
				str += "<td>" + eid + "</td>";
				str += "<td>" + price + "</td>";
				str += "<td>" + paymentway + "</td>";
				str += "<td>" + type + "</td>";
				str += "<td>" + time + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteEmployee("
						+ cid
						+ ")'/><input type='button' value='修改' onclick='modifyEmployee(\""
						+ cid + "\")'/></td>";
				str += "</tr>";
			}
		} else {
			str += "<tr>";
			str += "<td><input type='checkbox' name='checkname'/></td>";
			str += "<td>" + result.cid + "</td>";
			str += "<td>" + result.eid + "</td>";
			str += "<td>" + result.price + "</td>";
			str += "<td>" + result.paymentway + "</td>";
			str += "<td>" + result.type + "</td>";
			str += "<td>" + result.time + "</td>";
			str += "<td><input type='button' value='删除' onclick='deleteEmployee("
					+ id
					+ ")'/><input type='button' value='修改' onclick='modifyEmployee("
					+ name + ")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=9><ul>";
		str += "<td></td>";
		str += "</tr>";
	}
	return str;
}//将Ajax返回值转换成House对象
//将Ajax返回值转换成House对象
function result2house(result) {
	result = eval("(" + result + ")").message;
	console.log(result);
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='javascript:document.getElementsByClassName(\"dialog-reginster-employee\")[0].style.display=\"block\"' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=5><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"employee\")'/></td>";
	str += "</tr>";
	str += "<tr>";
	str += "<th><input type='checkbox' name='checkname' id='fcheckbox' onclick='checkAll(this)'/></th>";
	str += "<th onclick='changeOrder(this,\"employee\")'>编号</th>";
	str += "<th>楼盘名称</th>";
	str += "<th>楼盘号码</th>";
	str += "<th>楼盘类型</th>";
	str += "<th>楼盘价格</th>";
	str += "<th>楼盘面积</th>";
	str += "<th>操作人员</th>";
	str += "<th>楼盘时间</th>";
	str += "</tr>";
	if (result != null) {
		if (result.length) {
			for (var i = 0; i < result.length; i++) {
				var hou = result[i];
				var id = hou.id;
				var name = hou.name;
				var number = hou.number;
				var type = hou.type;
				var price = hou.price;
				var erea = hou.erea;
				var eid = hou.eid;
				var time = hou.time;
				str += "<tr>";
				str += "<td><input type='checkbox' name='checkname' class='scheckbox' lang='"
						+ id + "'/></td>"
				str += "<td>" + name + "</td>";
				str += "<td>" + number + "</td>";
				str += "<td>" + type + "</td>";
				str += "<td>" + price + "</td>";
				str += "<td>" + erea + "</td>";
				str += "<td>" + eid + "</td>";
				str += "<td>" + time + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteEmployee("
						+ id
						+ ")'/><input type='button' value='修改' onclick='modifyEmployee(\""
						+ name + "\")'/></td>";
				str += "</tr>";
			}
		} else {
			str += "<tr>";
			str += "<td><input type='checkbox' name='checkname'/></td>";
			str += "<td>" + result.id + "</td>";
			str += "<td>" + result.name + "</td>";
			str += "<td>" + result.number + "</td>";
			str += "<td>" + result.type + "</td>";
			str += "<td>" + result.price + "</td>";
			str += "<td>" + result.erea + "</td>";
			str += "<td>" + result.eid + "</td>";
			str += "<td>" + result.time + "</td>";
			str += "<td><input type='button' value='删除' onclick='deleteEmployee("
					+ id
					+ ")'/><input type='button' value='修改' onclick='modifyEmployee("
					+ name + ")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=9><ul>";
		str += "<td></td>";
		str += "</tr>";
	}
	return str;
}

//页面展开/折叠功能
function ocDetail(detail) {
    var main_left = document.getElementsByClassName("main-left")[0];
    var main_right = document.getElementsByClassName("main-right")[0];
    var label_flag = document.getElementById("detail-flag");
    if (label_flag.textContent == "<") {
        main_left.style.width = "0";
        main_left.style.display = "none";
        label_flag.innerHTML = ">";
        detail.style.left = "0";
    } else {
        main_left.style.width = "20%";
        label_flag.innerHTML = "<";
        detail.style.left = "20%";
        main_left.style.display = "block";
    }
}
