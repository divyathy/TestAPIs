package Common;

public enum BaseURI {
    sampleURI("http://dummy.restapiexample.com/api/v1/employees");

    private final String baseURI;
    BaseURI(String baseURI) {this.baseURI=baseURI;}
    public String getBaseURI() {return this.baseURI;}
}
