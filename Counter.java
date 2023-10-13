public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public void add() {
        if (closed) {
            throw new IllegalStateException("Счетчик уже закрыт");
        }
        count++;
    }

    @Override
    public void close() {
        if (!closed) {
            closed = true;
        }
    }

    public int getCount() {
        return count;
    }
}
