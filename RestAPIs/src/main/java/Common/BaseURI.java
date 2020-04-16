package Common;

public enum BaseURI {
    baseURL("http://dummy.restapiexample.com");
   /* sampleURI("http://dummy.restapiexample.com/api/v1/employees"),
    employeeURI("http://dummy.restapiexample.com/api/v1/employee/1"),
    createEmployeeID("http://dummy.restapiexample.com/api/v1/create"),
    updateEmployeeID("http://dummy.restapiexample.com/api/v1/update/21"),
    deleteEmployeeID("http://dummy.restapiexample.com/api/v1/delete/2");*/

    private final String baseURI;
    BaseURI(String baseURI) {this.baseURI=baseURI;}
    public String getBaseURI() {return this.baseURI;}
}
