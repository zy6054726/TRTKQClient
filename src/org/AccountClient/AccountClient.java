package org.AccountClient;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.AccountAes.AES;
import org.tempuri.Service1SoapProxy;

public class AccountClient {
	private String url;

	public static void main(String[] args) {

		AccountClient client = new AccountClient();
//		client.createUser("20221214", "", "张智3", "1", "01090200", "", "", "", "", "", "", new Date(), "启用", "在职人员",
//				"", "", "", "", "ACc123@12", "zhangzhi");
//		client.modifyUser("1000023123", "", "", "", "", "", "", "", "", "", "", new Date(), "", "", "", "", 
//				"", "", "Aa@123456", "");
//		client.disableUser("1000023123", "", "", "", "", "", "", "", "", "", "", new Date(), "", "", 
//				"", "", "", "", "", "");
//		client.enableUser("1000023123", "", "", "", "", "", "", "", "", "", "", new Date(), 
//				"", "", "", "", "", "", "", "");
		client.changePassWord("20221214", "", "", "", "", "", "", "", "", "", "", new Date(), "", "", "", 
				"", "", "", "Test@2016", "");
	}

	public AccountClient() {
//		this.url = "http://trttest.kaoqin.net/formobi.asmx?wsdl ";
		this.url = "http://10.8.154.18:81/formobi.asmx?wsdl";
	}

	public AccountClient(String url) {
		this.url = url;
	}
	
	/** 新建
	 * @param EMPNO    员工编号
	 * @param country  国家
	 * @param DISPLAYNAME  姓名
	 * @param SEX   性别
	 * @param DEPTCODE 部门编号
	 * @param title  职级
	 * @param TITLECODE 职级编号
	 * @param POSTCODE  岗位编码
	 * @param POST    岗位
	 * @param IDCARD  身份证号
	 * @param STATION 民族
	 * @param ENTRYDATE 入职时间
	 * @param STATUS 员工状态
	 * @param EMPTYPE 人员类别
	 * @param MOBILE  手机号码
	 * @param TELEPHONE 办公号码
	 * @param WORKADDRESS 工作地点
	 * @param COMPANY 公司名称
	 * @param password 密码
	 * @param username 登录login
	 * @return 0000 表示执行成功，当为0001表示执行失败，当为0003表示发生异常
	 */
	public String createUser(String EMPNO, String country, String DISPLAYNAME,
			String SEX, String DEPTCODE, String title, String TITLECODE,
			String POSTCODE, String POST, String IDCARD, String STATION,
			Date ENTRYDATE, String STATUS, String EMPTYPE, String MOBILE,
			String TELEPHONE, String WORKADDRESS, String COMPANY,
			String password, String username) {

		String ret = "";
		String flag = "01";
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		
		System.out.println("create 方法  EMPNO》" + EMPNO
				+ "--country>" + country
				+ "--DISPLAYNAME>" + DISPLAYNAME
				+ "--SEX>" + SEX + "--DEPTCODE>"
				+ DEPTCODE + "--title>" + title
				+ "--TITLECODE>" + TITLECODE
				+ "--POSTCODE>" + POSTCODE
				+ "--POST>" + POST + "--IDCARD>"
				+ IDCARD + "--STATION" + STATION
				+ "--ENTRYDATE>" + ENTRYDATE
				+ "--STATUS>" + STATUS + "--EMPTYPE"
				+ EMPTYPE + "--MOBILE>" + MOBILE
				+ "--TELEPHONE>" + TELEPHONE
				+ "--WORKADDRESS>" + WORKADDRESS
				+ "--COMPANY>" + COMPANY
				+ "--password>" + password
				+ "--username>" + username
				+ "--flag>" + flag);
		if("男".equals(SEX)){
			SEX = "1";
		}else if("女".equals(SEX)){
			SEX = "2";
		}
		
		if ("Active".equals(STATUS) || "".equals(STATUS)) {
			STATUS = "启用";
		} else if ("Disabled".equals(STATUS) || "Deleted".equals(STATUS)) {
			STATUS = "禁用";
		}

		if ("Full-Time".equals(EMPTYPE) || "Intern".equals(EMPTYPE)
				|| "EMP".equals(EMPTYPE)) {
			EMPTYPE = "在职人员";
		} else if ("NONW".equals(EMPTYPE)) {
			EMPTYPE = "离职人员";
		} else if ("CWK".equals(EMPTYPE)) {
			EMPTYPE = "实习人员";
		} else if ("Temp".equals(EMPTYPE)) {
			EMPTYPE = "返聘人员";
		} else if ("Part-Time".equals(EMPTYPE)) {
			EMPTYPE = "派遣人员";
		} else if ("Contractor".equals(EMPTYPE)) {
			EMPTYPE = "外包人员";
		} else if ("OTHER".equals(EMPTYPE) || "Consultant".equals(EMPTYPE)) {
			EMPTYPE = "其他";
		}
		
//		System.out.println("时间："+sdf.format(ENTRYDATE).equals("2016-9-17"));
		System.out.println("时间："+sdf.format(ENTRYDATE));
		try {
			Service1SoapProxy accountService = new Service1SoapProxy();
			ret = accountService.rec_dept(EMPNO, country, DISPLAYNAME, SEX,
					DEPTCODE, title, TITLECODE, POSTCODE, POST, IDCARD,
					STATION, sdf.format(ENTRYDATE), STATUS, EMPTYPE, MOBILE, TELEPHONE,
					WORKADDRESS, COMPANY, AES.Encrypt(password, "1234567890123456"), username, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("create=" + ret);
		return ret;
	}
	
	/** 修改
	 * @param EMPNO    员工编号
	 * @param country  国家
	 * @param DISPLAYNAME  姓名
	 * @param SEX   性别
	 * @param DEPTCODE 部门编号
	 * @param title  职级
	 * @param TITLECODE 职级编号
	 * @param POSTCODE  岗位编码
	 * @param POST    岗位
	 * @param IDCARD  身份证号
	 * @param STATION 民族
	 * @param ENTRYDATE 入职时间
	 * @param STATUS 员工状态
	 * @param EMPTYPE 人员类别
	 * @param MOBILE  手机号码
	 * @param TELEPHONE 办公号码
	 * @param WORKADDRESS 工作地点
	 * @param COMPANY 公司名称
	 * @param password 密码
	 * @param username 登录login
	 * @return 0000 表示执行成功，当为0001表示执行失败，当为0003表示发生异常
	 */
	public String modifyUser(String EMPNO, String country, String DISPLAYNAME,
			String SEX, String DEPTCODE, String title, String TITLECODE,
			String POSTCODE, String POST, String IDCARD, String STATION,
			Date ENTRYDATE, String STATUS, String EMPTYPE, String MOBILE,
			String TELEPHONE, String WORKADDRESS, String COMPANY,
			String password, String username) {

		String ret = "";
		String flag = "02";
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		System.out.println("modify 方法  EMPNO》" + EMPNO
				+ "--country>" + country
				+ "--DISPLAYNAME>" + DISPLAYNAME
				+ "--SEX>" + SEX + "--DEPTCODE>"
				+ DEPTCODE + "--title>" + title
				+ "--TITLECODE>" + TITLECODE
				+ "--POSTCODE>" + POSTCODE
				+ "--POST>" + POST + "--IDCARD>"
				+ IDCARD + "--STATION" + STATION
				+ "--ENTRYDATE>" + ENTRYDATE
				+ "--STATUS>" + STATUS + "--EMPTYPE"
				+ EMPTYPE + "--MOBILE>" + MOBILE
				+ "--TELEPHONE>" + TELEPHONE
				+ "--WORKADDRESS>" + WORKADDRESS
				+ "--COMPANY>" + COMPANY
				+ "--password>" + password
				+ "--username>" + username
				+ "--flag>" + flag);
		if ("Active".equals(STATUS) || "".equals(STATUS)) {
			STATUS = "启用";
		} else if ("Disabled".equals(STATUS) || "Deleted".equals(STATUS)) {
			STATUS = "禁用";
		}
		
		if("男".equals(SEX)){
			SEX = "1";
		}else if("女".equals(SEX)){
			SEX = "2";
		}

		if ("Full-Time".equals(EMPTYPE) || "Intern".equals(EMPTYPE)
				|| "EMP".equals(EMPTYPE)) {
			EMPTYPE = "在职人员";
		} else if ("NONW".equals(EMPTYPE)) {
			EMPTYPE = "离职人员";
		} else if ("CWK".equals(EMPTYPE)) {
			EMPTYPE = "实习人员";
		} else if ("Temp".equals(EMPTYPE)) {
			EMPTYPE = "返聘人员";
		} else if ("Part-Time".equals(EMPTYPE)) {
			EMPTYPE = "派遣人员";
		} else if ("Contractor".equals(EMPTYPE)) {
			EMPTYPE = "外包人员";
		} else if ("OTHER".equals(EMPTYPE) || "Consultant".equals(EMPTYPE)) {
			EMPTYPE = "其他";
		}

		try {
			Service1SoapProxy accountService = new Service1SoapProxy();
			ret = accountService.rec_dept(EMPNO, country, DISPLAYNAME, SEX,
					DEPTCODE, title, TITLECODE, POSTCODE, POST, IDCARD,
					STATION, sdf.format(ENTRYDATE), STATUS, EMPTYPE, MOBILE, TELEPHONE,
					WORKADDRESS, COMPANY, AES.Encrypt(password, "1234567890123456"), username, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("modify=" + ret);
		return ret;
	}
	
	/** 禁用
	 * @param EMPNO    员工编号
	 * @param country  国家
	 * @param DISPLAYNAME  姓名
	 * @param SEX   性别
	 * @param DEPTCODE 部门编号
	 * @param title  职级
	 * @param TITLECODE 职级编号
	 * @param POSTCODE  岗位编码
	 * @param POST    岗位
	 * @param IDCARD  身份证号
	 * @param STATION 民族
	 * @param ENTRYDATE 入职时间
	 * @param STATUS 员工状态
	 * @param EMPTYPE 人员类别
	 * @param MOBILE  手机号码
	 * @param TELEPHONE 办公号码
	 * @param WORKADDRESS 工作地点
	 * @param COMPANY 公司名称
	 * @param password 密码
	 * @param username 登录login
	 * @return 0000 表示执行成功，当为0001表示执行失败，当为0003表示发生异常
	 */
	public String disableUser(String EMPNO, String country, String DISPLAYNAME,
			String SEX, String DEPTCODE, String title, String TITLECODE,
			String POSTCODE, String POST, String IDCARD, String STATION,
			Date ENTRYDATE, String STATUS, String EMPTYPE, String MOBILE,
			String TELEPHONE, String WORKADDRESS, String COMPANY,
			String password, String username) {

		String ret = "";
		String flag = "03";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("disable 方法  EMPNO》" + EMPNO
				+ "--flag>" + flag);
		
		if ("Active".equals(STATUS) || "".equals(STATUS)) {
			STATUS = "启用";
		} else if ("Disabled".equals(STATUS) || "Deleted".equals(STATUS)) {
			STATUS = "禁用";
		}

		if ("Full-Time".equals(EMPTYPE) || "Intern".equals(EMPTYPE)
				|| "EMP".equals(EMPTYPE)) {
			EMPTYPE = "在职人员";
		} else if ("NONW".equals(EMPTYPE)) {
			EMPTYPE = "离职人员";
		} else if ("CWK".equals(EMPTYPE)) {
			EMPTYPE = "实习人员";
		} else if ("Temp".equals(EMPTYPE)) {
			EMPTYPE = "返聘人员";
		} else if ("Part-Time".equals(EMPTYPE)) {
			EMPTYPE = "派遣人员";
		} else if ("Contractor".equals(EMPTYPE)) {
			EMPTYPE = "外包人员";
		} else if ("OTHER".equals(EMPTYPE) || "Consultant".equals(EMPTYPE)) {
			EMPTYPE = "其他";
		}

		try {
			Service1SoapProxy accountService = new Service1SoapProxy();
			ret = accountService.rec_dept(EMPNO, country, DISPLAYNAME, SEX,
					DEPTCODE, title, TITLECODE, POSTCODE, POST, IDCARD,
					STATION, sd.format(ENTRYDATE), STATUS, EMPTYPE, MOBILE, TELEPHONE,
					WORKADDRESS, COMPANY, AES.Encrypt(password, "1234567890123456"), username, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("disable=" + ret);
		return ret;
	}
	
	/** 启用
	 * @param EMPNO    员工编号
	 * @param country  国家
	 * @param DISPLAYNAME  姓名
	 * @param SEX   性别
	 * @param DEPTCODE 部门编号
	 * @param title  职级
	 * @param TITLECODE 职级编号
	 * @param POSTCODE  岗位编码
	 * @param POST    岗位
	 * @param IDCARD  身份证号
	 * @param STATION 民族
	 * @param ENTRYDATE 入职时间
	 * @param STATUS 员工状态
	 * @param EMPTYPE 人员类别
	 * @param MOBILE  手机号码
	 * @param TELEPHONE 办公号码
	 * @param WORKADDRESS 工作地点
	 * @param COMPANY 公司名称
	 * @param password 密码
	 * @param username 登录login
	 * @return 0000 表示执行成功，当为0001表示执行失败，当为0003表示发生异常
	 */
	public String enableUser(String EMPNO, String country, String DISPLAYNAME,
			String SEX, String DEPTCODE, String title, String TITLECODE,
			String POSTCODE, String POST, String IDCARD, String STATION,
			Date ENTRYDATE, String STATUS, String EMPTYPE, String MOBILE,
			String TELEPHONE, String WORKADDRESS, String COMPANY,
			String password, String username) {

		String ret = "";
		String flag = "04";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("enable 方法  EMPNO》" + EMPNO
				+ "--flag>" + flag);
		
		if ("Active".equals(STATUS) || "".equals(STATUS)) {
			STATUS = "启用";
		} else if ("Disabled".equals(STATUS) || "Deleted".equals(STATUS)) {
			STATUS = "禁用";
		}

		if ("Full-Time".equals(EMPTYPE) || "Intern".equals(EMPTYPE)
				|| "EMP".equals(EMPTYPE)) {
			EMPTYPE = "在职人员";
		} else if ("NONW".equals(EMPTYPE)){
			EMPTYPE = "离职人员";
		} else if ("CWK".equals(EMPTYPE)) {
			EMPTYPE = "实习人员";
		} else if ("Temp".equals(EMPTYPE)) {
			EMPTYPE = "返聘人员";
		} else if ("Part-Time".equals(EMPTYPE)) {
			EMPTYPE = "派遣人员";
		} else if ("Contractor".equals(EMPTYPE)) {
			EMPTYPE = "外包人员";
		} else if ("OTHER".equals(EMPTYPE) || "Consultant".equals(EMPTYPE)) {
			EMPTYPE = "其他";
		}

		try {
			Service1SoapProxy accountService = new Service1SoapProxy();
			ret = accountService.rec_dept(EMPNO, country, DISPLAYNAME, SEX,
					DEPTCODE, title, TITLECODE, POSTCODE, POST, IDCARD,
					STATION, sd.format(ENTRYDATE), STATUS, EMPTYPE, MOBILE, TELEPHONE,
					WORKADDRESS, COMPANY, AES.Encrypt(password, "1234567890123456"), username, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("enable=" + ret);
		return ret;
	}
	
	/** 改密
	 * @param EMPNO    员工编号
	 * @param country  国家
	 * @param DISPLAYNAME  姓名
	 * @param SEX   性别
	 * @param DEPTCODE 部门编号
	 * @param title  职级
	 * @param TITLECODE 职级编号
	 * @param POSTCODE  岗位编码
	 * @param POST    岗位
	 * @param IDCARD  身份证号
	 * @param STATION 民族
	 * @param ENTRYDATE 入职时间
	 * @param STATUS 员工状态
	 * @param EMPTYPE 人员类别
	 * @param MOBILE  手机号码
	 * @param TELEPHONE 办公号码
	 * @param WORKADDRESS 工作地点
	 * @param COMPANY 公司名称
	 * @param password 密码
	 * @param username 登录login
	 * @return 0000 表示执行成功，当为0001表示执行失败，当为0003表示发生异常
	 */
	public String changePassWord(String EMPNO, String country, String DISPLAYNAME,
			String SEX, String DEPTCODE, String title, String TITLECODE,
			String POSTCODE, String POST, String IDCARD, String STATION,
			Date ENTRYDATE, String STATUS, String EMPTYPE, String MOBILE,
			String TELEPHONE, String WORKADDRESS, String COMPANY,
			String password, String username) {

		String ret = "";
		String flag = "05";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("changePassWord 方法  EMPNO》" + EMPNO
				+ "--password>" + password
				+ "--flag>" + flag);
		
		if ("Active".equals(STATUS) || "".equals(STATUS)) {
			STATUS = "启用";
		} else if ("Disabled".equals(STATUS) || "Deleted".equals(STATUS)) {
			STATUS = "禁用";
		}

		if ("Full-Time".equals(EMPTYPE) || "Intern".equals(EMPTYPE)
				|| "EMP".equals(EMPTYPE)) {
			EMPTYPE = "在职人员";
		} else if ("NONW".equals(EMPTYPE)){
			EMPTYPE = "离职人员";
		} else if ("CWK".equals(EMPTYPE)) {
			EMPTYPE = "实习人员";
		} else if ("Temp".equals(EMPTYPE)) {
			EMPTYPE = "返聘人员";
		} else if ("Part-Time".equals(EMPTYPE)) {
			EMPTYPE = "派遣人员";
		} else if ("Contractor".equals(EMPTYPE)) {
			EMPTYPE = "外包人员";
		} else if ("OTHER".equals(EMPTYPE) || "Consultant".equals(EMPTYPE)) {
			EMPTYPE = "其他";
		}

		try {
			Service1SoapProxy accountService = new Service1SoapProxy();
//			System.out.println("加密："+AES.Encrypt(password, "1234567890123456"));
			ret = accountService.rec_dept(EMPNO, country, DISPLAYNAME, SEX,
					DEPTCODE, title, TITLECODE, POSTCODE, POST, IDCARD,
					STATION, sd.format(ENTRYDATE), STATUS, EMPTYPE, MOBILE, TELEPHONE,
					WORKADDRESS, COMPANY, AES.Encrypt(password, "1234567890123456"), username, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("changePassWord=" + ret);
		return ret;
	}
	
}
