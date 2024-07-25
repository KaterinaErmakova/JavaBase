public class SellProductException extends Exception {
    private SellExceptionReason reason;
    public SellProductException(SellExceptionReason reason) {
        this.reason = reason;
    }
    public SellExceptionReason getReason() {
        return reason;
    }
}
