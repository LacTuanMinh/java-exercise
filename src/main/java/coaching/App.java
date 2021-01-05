package coaching;

import java.io.IOException;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws Exception {
        try (CustomResource resource = new CustomResource()) {
            System.out.println("try block");
            throw new Exception();
        } catch (IOException e) {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch Exception");

        } finally {
            System.out.println("finally block");
        }
    }

    private static class CustomResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("resource has been closed");
        }
    }
}
