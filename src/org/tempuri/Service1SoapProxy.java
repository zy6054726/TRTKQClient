package org.tempuri;

public class Service1SoapProxy implements org.tempuri.Service1Soap {
  private String _endpoint = null;
  private org.tempuri.Service1Soap service1Soap = null;
  
  public Service1SoapProxy() {
    _initService1SoapProxy();
  }
  
  public Service1SoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initService1SoapProxy();
  }
  
  private void _initService1SoapProxy() {
    try {
      service1Soap = (new org.tempuri.Service1Locator()).getService1Soap();
      if (service1Soap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service1Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service1Soap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service1Soap != null)
      ((javax.xml.rpc.Stub)service1Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.Service1Soap getService1Soap() {
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap;
  }
  
  public java.lang.String rec_dept(java.lang.String EMPNO, java.lang.String country, java.lang.String DISPLAYNAME, java.lang.String SEX, java.lang.String DEPTCODE, java.lang.String title, java.lang.String TITLECODE, java.lang.String POSTCODE, java.lang.String POST, java.lang.String IDCARD, java.lang.String STATION, java.lang.String ENTRYDATE, java.lang.String STATUS, java.lang.String EMPTYPE, java.lang.String MOBILE, java.lang.String TELEPHONE, java.lang.String WORKADDRESS, java.lang.String COMPANY, java.lang.String password, java.lang.String username, java.lang.String flag) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.rec_dept(EMPNO, country, DISPLAYNAME, SEX, DEPTCODE, title, TITLECODE, POSTCODE, POST, IDCARD, STATION, ENTRYDATE, STATUS, EMPTYPE, MOBILE, TELEPHONE, WORKADDRESS, COMPANY, password, username, flag);
  }
  
  
}