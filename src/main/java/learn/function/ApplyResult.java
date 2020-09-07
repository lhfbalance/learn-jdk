package learn.function;

public class ApplyResult {

    String id;

    Result result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApplyResult{" + "id='" + id + '\'' + ", result=" + result + '}';
    }
}
