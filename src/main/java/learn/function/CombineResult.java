package learn.function;

public class CombineResult {

    ApplyResult applyResult;

    Result result;

    public ApplyResult getApplyResult() {
        return applyResult;
    }

    public void setApplyResult(ApplyResult applyResult) {
        this.applyResult = applyResult;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CombineResult{" + "applyResult=" + applyResult + ", result=" + result + '}';
    }
}
