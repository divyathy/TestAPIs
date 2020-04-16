package Common;

public enum Endpoints {

    employeesAPI("/api/v1/employees"),
    employeeID("/api/v1/employee/1"),
    createEmpID("/api/v1/create"),
    updateEmpID("/api/v1/update/21"),
    deleteEmpID("/api/v1/delete/2");


    private final String endpointURI;

    Endpoints(String endpoint) {this.endpointURI=endpoint;}

    public String getEndpointURI() {
        return this.endpointURI;
    }
}
