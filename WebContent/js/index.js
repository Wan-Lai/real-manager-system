var employees;
var customers;
var finances;
var houses;

window.onload = function() {
	// 默认查看员工
	changeEmployee();

}
// 查看员工信息
function changeEmployee() {
	var show_table = document.getElementById("data_table");	
	show_table.style.height = "auto";
	show_table.style.width = "90%";
	MyAjax("employee", "queryAll", "", function(result) {
		result = eval("(" + result + ")");
		var rst = result2employee(result.message);
		show_table.innerHTML = rst;
	});
}
// 查看顾客信息
function changeCustomer() { 
	var show_table = document.getElementById("data_table");	
	show_table.style.height = "auto";
	show_table.style.width = "90%";
	MyAjax("customer", "queryAll", "", function(result) {
		result = eval("(" + result + ")");
		show_table.innerHTML = result2customer(result.message);
	});
}
// 查看账单信息
function changeFinance() {
	var show_table = document.getElementById("data_table");	
	show_table.style.height = "auto";
	show_table.style.width = "90%";
	MyAjax("finance", "queryAll", "", function(result) {
		result = eval("(" + result + ")");
		show_table.innerHTML = result2finance(result.message);
	});
}
// 查看账单UI界面
function changeFinanceUI() {
	var show_table = document.getElementById("data_table");
	show_table.style.height = "400px";
	show_table.style.width = "400px";
	show_table.innerHTML = "";
	var datas  = [];
	for(var i=0; i<finances.length; i++) {
		var data = {};
		data.value = finances[i].price;
		data.name = finances[i].cid+","+finances[i].eid;
		datas.push(data);
	}
	for(var i=0; i<datas.length; i++) {
		var name = datas[i];
		var rstname = "[";
		for(var j=0; j<customers.length; j++) {
			if(name.name.split(",")[0] == customers[j].id)
				rstname += customers[j].name;
		}
		for(var j=0; j<employees.length; j++) {
			if(name.name.split(",")[1] == employees[j].id)
				rstname += ":"+employees[j].name;
				
		}
		datas[i].name = rstname+"]";
	}
	var names = [];
	for(var i=0; i<datas.length; i++) {
		datas[i].name += ":"+datas[i].value;
		names.push(datas[i].name);
	}
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(show_table);
    // 指定图表的配置项和数据
    var option = {
      legend: { orient: 'vertical', x: 'left', data: names },
	  series: [ { type: 'pie', radius: ['40%', '70%'], avoidLabelOverlap: false,label: { show: false, position: 'center', emphasis: { show: true } },labelLine: { show: false },emphasis: { label: { show: true, fontSize: '30', fontWeight: 'bold' } },data: datas } ] };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
// 查看楼盘信息
function changeHouse() {
	var show_table = document.getElementById("data_table");	
	show_table.style.height = "auto";
	show_table.style.width = "90%";
	MyAjax("house", "queryAll", "", function(result) {
		result = eval("(" + result + ")");
		show_table.innerHTML = result2house(result.message);
	});
}

// 将Ajax返回值转换成Employee对象
function result2employee(result) {
	employees = result;
//	console.log(result);
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='addEmployee()' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=6><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"employee\")'/></td>";
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
				str += "<td>" + id + "</td>";
				str += "<td>" + name + "</td>";
				str += "<td>" + username + "</td>";
				str += "<td>" + gender + "</td>";
				str += "<td>" + age + "</td>";
				str += "<td>" + phone + "</td>";
				str += "<td>" + department + "</td>";
				str += "<td>" + position + "</td>";
				str += "<td>" + salary + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteEmployee("+ id
						+ ")'/><input type='button' value='修改' onclick='updateEmployee(\""
						+ id + "\")'/></td>";
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
			str += "<td><input type='button' value='删除' onclick='deleteEmployee("+ result
			+ ")'/><input type='button' value='修改' onclick='updateEmployee(\""
			+ result.id + "\")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=10><ul>";
		str += "<td colspan=1></td>";
		str += "</tr>";
	}
	return str;
}
//将Ajax返回值转换成Customer对象
function result2customer(result) {
//	console.log(result);
	customers = result;
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='addCustomer()' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=7><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"customer\")'/></td>";
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
				str += "<td>" + id + "</td>";
				str += "<td>" + name + "</td>";
				str += "<td>" + address + "</td>";
				str += "<td>" + buyaddress + "</td>";
				str += "<td>" + phone + "</td>";
				str += "<td>" + idnum + "</td>";
				str += "<td>" + idstatu + "</td>";
				str += "<td>" + time + "</td>";
				str += "<td>" + wanttype + "</td>";
				str += "<td>" + commend + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteCustomer("
						+ id
						+ ")'/><input type='button' value='修改' onclick='updateCustomer(\""
						+ id + "\")'/></td>";
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
					+ ")'/><input type='button' value='修改' onclick='updateEmployee("
					+ name + ")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=11><ul>";
		str += "<td colspan=1></td>";
		str += "</tr>";
	}
	return str;
}
//将Ajax返回值转换成Finance对象
function result2finance(result) {
//	console.log(result);
	finances = result;
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='addFinance()' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=5><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"finance\")'/></td>";
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
				str += "<td><input type='button' value='删除' onclick='deleteFinance("+ cid + "," + eid + ")'/><input type='button' value='修改' onclick='updateFinance("
						+ cid + "," + eid + ")'/></td>";
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
			str += "<td><input type='button' value='删除' onclick='deleteFinance("+ result.cid + "," + result.eid + ")'/><input type='button' value='修改' onclick='updateFinance("
				+ result.cid + "," + result.eid + ")'/></td>";
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
//	console.log(result);
	houses = result;
	var str = "";
	str += "<tr>";
	str += "<td></td>";
	str += "<td colspan=2><input type='button' onclick='addHouse()' value='添加'/></td>";
	str += "<td colspan=2><input type='button' value='删除'/></td>";
	str += "<td colspan=5><input type='text' placeholder='请输入姓名' id='searchname'/><input type='button' value='搜索' onclick='searchByName(\"house\")'/></td>";
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
				str += "<td>" + id + "</td>";
				str += "<td>" + name + "</td>";
				str += "<td>" + number + "</td>";
				str += "<td>" + type + "</td>";
				str += "<td>" + price + "</td>";
				str += "<td>" + erea + "</td>";
				str += "<td>" + eid + "</td>";
				str += "<td>" + time + "</td>";
				str += "<td><input type='button' value='删除' onclick='deleteHouse("+ id
						+ ")'/><input type='button' value='修改' onclick='updateHouse(\""
						+ id + "\")'/></td>";
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
			str += "<td><input type='button' value='删除' onclick='deleteHouse("+ result.id
			+ ")'/><input type='button' value='修改' onclick='updateHouse(\""
			+ result.id + "\")'/></td>";
			str += "</tr>";
		}
		str += "<tr>";
		str += "<td colspan=1></td>";
		str += "<td colspan=9><ul>";
		str += "<td colspan=2></td>";
		str += "</tr>";
	}
	return str;
}

// 添加用户
function addEmployee() {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-employee")[0].style.display="block";
	var form = document.getElementById("dialog-login-employee");
	// 清空表单
	form.reset();
	form.btn.value = "添加";
	form.btn.onclick = function(){
		var name = form.ename.value;
		var username = form.eusername.value;
		var gender = form.egender.value;
		var age = form.eage.value;
		var phone = form.ephone.value;
		var department = form.edepartment.value;
		var position = form.eposition.value;
		var salary = form.esalary.value;
		if(!(name&&username&&gender&&age&&phone&&department&&position&&salary)){
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&name=" + name + "&username=" + username + "&gender=" + gender + 
		"&age=" + age + "&phone=" + phone + "&department=" + department + 
		"&position=" + position + "&salary=" + salary; 
		MyAjax("employee", "add", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("添加成功");		
				document.getElementsByClassName("dialog-reginster-employee")[0].style.display="none";
				changeEmployee();
			}else {
				alert("添加失败");
			}
			console.log("Employee添加操作:" + result);
		})
	}
}
// 删除用户
function deleteEmployee(id) {
	MyAjax("employee","delete","&id="+id,function(result){
		var rst = eval("(" + result + ")");
		if(rst.code == 200) {
			alert("删除成功!");
		} else {
			alert("删除失败!");
		}
		console.log("Employee删除"+result);
		changeEmployee();
	});
}
// 修改用户
function updateEmployee(id) {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-employee")[0].style.display="block";
	var form = document.getElementById("dialog-login-employee");
	form.reset();
	var emp;
	for(var i=0; i<employees.length; i++){
		if(employees[i].id == id) {
			emp = employees[i];
		}
	}
	console.log(emp);
	form.eno.value = emp.id;
	form.ename.value = emp.name;
	form.eusername.value = emp.username;
	form.egender.value = emp.gender;
	form.eage.value = emp.age;
	form.ephone.value = emp.phone;
	form.edapartment.value = emp.dapartment;
	form.eposition.value = emp.position;
	form.esalary.value = emp.salary;
	form.btn.value = "修改";
	form.btn.onclick = function(){
		var id = form.eno.value;
		var name = form.ename.value;
		var username = form.eusername.value;
		var gender = form.egender.value;
		var age = form.eage.value;
		var phone = form.ephone.value;
		var department = form.edepartment.value;
		var position = form.eposition.value;
		var salary = form.esalary.value;
		if(!(name&&username&&gender&&age&&phone&&department&&position&&salary)){
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&id=" + id + "&name=" + name + "&username=" + username + "&gender=" + gender + 
		"&age=" + age + "&phone=" + phone + "&department=" + department + 
		"&position=" + position + "&salary=" + salary; 
		MyAjax("employee", "update", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("更新成功");
				document.getElementsByClassName("dialog-reginster-employee")[0].style.display="none";
				changeEmployee();
			}else {
				alert("更新失败");
			}
			console.log("Employee更新操作:" + result);
		})
	}
}


// 添加顾客
function addCustomer() {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-customer")[0].style.display="block";
	var form = document.getElementById("dialog-login-customer");
	// 清空表单
	form.reset();
	form.btn.value = "添加";
	form.btn.onclick = function(){
		var name = form.cname.value;
		var address = form.caddress.value;
		var buyaddress = form.cbuyaddress.value;
		var phone = form.cphone.value;
		var idnum = form.cidnum.value;
		var idstatu = form.cidstatu.value;
		var wanttype = form.cwanttype.value;
		var commend = form.ccommend.value;
		if(!(name&&address&&buyaddress&&phone&&idnum&&idstatu&&wanttype&&commend)) {
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&name=" + name + "&address=" + address + "&buyaddress=" + buyaddress +
				"&phone=" + phone + "&idnum=" + idnum + "&idstatu=" + idstatu + 
				"&wanttype=" + wanttype + "&commend=" + commend;
		MyAjax("customer", "add", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("添加成功");		
				document.getElementsByClassName("dialog-reginster-customer")[0].style.display="none";
				changeCustomer();
			}else {
				alert("添加失败");
			}
			console.log("Employee添加操作:" + result);
		});
	}
}
// 删除顾客
function deleteCustomer(id) {
	MyAjax("customer", "delete", "&id="+id, function(result) {
		var rst = eval("(" + result + ")");
		if(rst.code == 200) {
			alert("删除成功");
		} else {
			alert("删除失败");
		}
		console.log("Customer删除"+result);
		changeCustomer();
	});
}
// 修改顾客
function updateCustomer(id) {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-customer")[0].style.display="block";
	var form = document.getElementById("dialog-login-customer");
	form.reset();
	var cus;
	for(var i=0; i<customers.length; i++) {
		if(customers[i].id == id) {
			cus = customers[i];
		}
	}
	form.cid.value = cus.id;
	form.cname.value = cus.name;
	form.caddress.value = cus.address;
	form.cbuyaddress.value = cus.buyaddress;
	form.cphone.value = cus.phone;
	form.cidnum.value = cus.idnum;
	form.cidstatu.value = cus.idstatu;
	form.cwanttype.value = cus.wanttype;
	form.ccommend.value = cus.commend;
	form.btn.value = "更新";
	form.btn.onclick = function() {
		var id = form.cid.value;
		var name = form.cname.value;
		var address = form.caddress.value;
		var buyaddress = form.cbuyaddress.value;
		var phone = form.cphone.value;
		var idnum = form.cidnum.value;
		var idstatu = form.cidstatu.value;
		var wanttype = form.cwanttype.value;
		var commend = form.ccommend.value;
		if(!(id&&name&&address&&buyaddress&&phone&&idnum&&idstatu&&wanttype&&commend)) {
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&id=" + id + "&name=" + name + "&address=" + address + "&buyaddress=" + buyaddress +
				"&phone=" + phone + "&idnum=" + idnum + "&idstatu=" + idstatu + 
				"&wanttype=" + wanttype + "&commend=" + commend;
		console.log(values);
		MyAjax("customer", "update", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("更新成功");		
				document.getElementsByClassName("dialog-reginster-customer")[0].style.display="none";
				changeCustomer();
			}else {
				alert("更新失败");
			}
			console.log("Employee更新操作:" + result);
		});
	}
}


// 添加账单
function addFinance() {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-finance")[0].style.display="block";
	var form = document.getElementById("dialog-login-finance");
	// 清空表单
	form.reset();
	console.log(form);
	form.btn.value = "添加";
	form.btn.onclick = function(){
		var cid = form.cid.value;
		var eid = form.eid.value;
		var price = form.fprice.value;
		var paymentway = form.fpaymentway.value;
		var type = form.ftype.value;
		if(!(cid&&eid&&price&&paymentway&&type)) {
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&cid=" + cid + "&eid=" + eid + "&price=" + price +
				"&paymentway=" + paymentway + "&type=" + type;
		MyAjax("finance", "add", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("添加成功");		
				document.getElementsByClassName("dialog-reginster-finance")[0].style.display="none";
				changeFinance();
			}else {
				alert("添加失败");
			}
			console.log("Finance添加操作:" + result);
		});
	}
}
// 删除账单
function deleteFinance(cid, eid) {
	MyAjax("finance", "delete", "&cid="+cid+"&eid="+eid, function(result) {
		result = eval("(" + result + ")");
		if(result.code == 200) {
			alert("删除成功!");
			changeFinance();
		} else {
			alert("删除失败!");
		}
		console.log("Finance删除操作:" + result);
	});
}
// 修改账单
function updateFinance(cid, eid) {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-finance")[0].style.display="block";
	var form = document.getElementById("dialog-login-finance");
	// 清空表单
	form.reset();
	var fin;
	for(var i=0; i<finances.length; i++) {
		if((finances[i].cid == cid)&&(finances[i].eid == eid)) {
			fin = finances[i];
		}
	}
	form.cid.value = fin.cid;
	form.eid.value = fin.eid;
	form.fprice.value = fin.price;
	form.fpaymentway.value = fin.paymentway;
	form.ftype.value = fin.type;
	form.btn.value = "修改";
	form.btn.onclick = function() {
		var cid = form.cid.value;
		var eid = form.eid.value;
		var price = form.fprice.value;
		var paymentway = form.fpaymentway.value;
		var type = form.ftype.value;
		if(!(cid&&eid&&price&&paymentway&&type)) {
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&cid=" + cid + "&eid=" + eid + "&price=" + price +
				"&paymentway=" + paymentway + "&type=" + type;
		MyAjax("finance", "update", values, function(result){
			result = eval("(" + result + ")");
			if(result.code == 200) {
				alert("修改成功！");
				document.getElementsByClassName("dialog-reginster-finance")[0].style.display="none";
				changeFinance();
			} else {
				alert("修改失败！");
			}
			console.log("Finance修改操作:" + result);
		});
	}
}


// 添加楼盘
function addHouse() {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-house")[0].style.display="block";
	var form = document.getElementById("dialog-login-house");
	// 清空表单
	form.reset();
	form.btn.value = "添加";
	form.btn.onclick = function(){
		var name = form.hname.value;
		var number = form.hnumber.value;
		var type = form.htype.value;
		var price = form.hprice.value;
		var erea = form.herea.value;
		var eid = form.eid.value;
		var time = form.htime.value;
		if(!(name&&number&&type&&price&&erea&&eid&&time)){
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&name=" + name + "&number=" + number + "&type=" + type + 
		"&price=" + price + "&erea=" + erea + "&eid=" + eid + "&time=" + time; 
		console.log(values);
		MyAjax("house", "add", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("添加成功");		
				document.getElementsByClassName("dialog-reginster-house")[0].style.display="none";
				changeHouse();
			}else {
				alert("添加失败");
			}
			console.log("House添加操作:" + result);
		})
	}
}
// 删除楼盘
function deleteHouse(id) {
MyAjax("house", "delete", "&id="+id, function(result) {
	result = eval("(" + result + ")");
	if(result.code == 200) {
		alert("删除成功!");
		changeFinance();
	} else {
		alert("删除失败!");
	}
	console.log("House删除操作:" + result);
});
}
//修改楼盘
function updateHouse(id) {
	// 显示表单
	document.getElementsByClassName("dialog-reginster-house")[0].style.display="block";
	var form = document.getElementById("dialog-login-house");
	// 清空表单
	form.reset();
	var hou;
	for(var i=0; i<houses.length; i++) {
		if(houses[i].id == id) {
			hou = houses[i];
		}
	}
	form.hid.value = hou.id;
	form.hname.value = hou.name;
	form.hnumber.value = hou.number;
	form.htype.value = hou.type;
	form.hprice.value = hou.price;
	form.herea.value = hou.erea;
	form.eid.value = hou.eid;
	form.htime.value = hou.time;
	form.btn.value = "修改";
	form.btn.onclick = function() {
		var id = form.hid.value;
		var name = form.hname.value;
		var number = form.hnumber.value;
		var type = form.htype.value;
		var price = form.hprice.value;
		var erea = form.herea.value;
		var eid = form.eid.value;
		var time = form.htime.value;
		if(!(name&&number&&type&&price&&erea&&eid&&time)){
			alert("请将数据填写完整后重新提交！");
			return;
		}
		var values = "&id=" + id + "&name=" + name + "&number=" + number + "&type=" + type + 
		"&price=" + price + "&erea=" + erea + "&eid=" + eid + "&time=" + time; 
		MyAjax("house", "update", values, function(result){
			var rst = eval("(" + result + ")");
			if(rst.code == 200) {
				alert("修改成功");		
				document.getElementsByClassName("dialog-reginster-house")[0].style.display="none";
				changeHouse();
			} else {
				alert("修改失败！");
			}
			console.log("Finance修改操作:" + result);
		});
	}
}


//通过名字查询
function searchByName(entity) {
	var show_table = document.getElementById("data_table")
	var name = document.getElementById("searchname").value;
	var emp;
	var cus;
	var fin;
	var hou;
	var rst;
	switch(entity) {
	case "employee":
		for(var i=0; i<employees.length; i++) {
			if(employees[i].name == name) {
				emp = employees[i];
				break;
			}
		}
		rst = result2employee(emp);
		break;
	case "customer":
		for(var i=0; i<customers.length; i++) {
			if(customers[i].name == name) {
				cus = customers[i];
				break;
			}
		}
		rst = result2customer(cus);
		break;
	case "finance":
		for(var i=0; i<finances.length; i++) {
			if(finances[i].cid == name) {
				fin = finances[i];
				break;
			}
		}
		rst = result2finance(fin);
		break;	
	case "house":
		for(var i=0; i<houses.length; i++) {
			if(houses[i].name == name) {
				hou = houses[i];
				break;
			}
		}
		rst = result2house(hou);
		break;	
	}
	show_table.innerHTML = rst;
}

//自定义Ajax
function MyAjax(entity, operate, values, callback) {
	var service;
	var operate;
	switch (entity) {
		// 若为员工
		case "employee":
			service = "EmployeeService";
			break;
		// 若为顾客
		case "customer" :
			service = "CustomerService";
			break;
		// 若为账单
		case "finance" :
			service = "FinanceService";
			break;
			// 若为楼盘
		case "house" :
			service = "HouseService";
			break;
	}
	$.ajax({
		url : "./" + service + "?operate=" + operate + values,
		method : "post",
		success : function(result) {
			callback(result);
		}
	});
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
