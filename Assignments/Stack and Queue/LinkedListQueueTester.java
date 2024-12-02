interface TestCase {
    void run();
}

public class LinkedListQueueTester {
    public static void assertion(boolean expression)
    {
        if (expression == false)
            throw new AssertionError();
    }
    public static void assertion(boolean expression, String testMsg)
    {
        if (expression == false) {
            throw new AssertionError("Failed on: " + testMsg + "");
        }
    }
    private static void testCase(String name, TestCase test) {
        System.out.println("Starting test: " + name);
        try{
            test.run();
            System.out.println("Test okay: " + name);
            System.out.println("------------------------------------------------------------------------");
        }catch (AssertionError e) {
            System.err.println("TEST FAILED: " + name + e);
            System.out.println("!!!----FAIL----!!!!!!----FAIL----!!!!!!----FAIL----!!!!!!----FAIL----!!!");
			System.out.println("------------------------------------------------------------------------");
        }catch (Exception ex)
        {
            System.err.println("TEST FAILED: " + name + ex );
            System.out.println("!!!----FAIL----!!!!!!----FAIL----!!!!!!----FAIL----!!!!!!----FAIL----!!!");
			System.out.println("------------------------------------------------------------------------");
        }

    }

    // run a test case that should throw an exception
    private static void exceptTestCase(String name, TestCase test) {
        boolean passed = false;
        System.out.println("Starting test: Exception case: " + name);
        try {
            test.run();
        } catch(IllegalStateException e) {
            System.out.println("IllegalStateException thrown by: " + name);
            passed = true;
        } catch(Exception e) {
            System.out.println("Different exception thrown by: " + name + e);
            passed = false;
        }

        if (passed)
        {
            System.out.println("Exception Test okay: " + name);
            System.out.println("------------------------------------------------------------------------");
        }
        else
        {
            System.err.println("EXCEPTION TEST FAILED: " + name);
            System.out.println("!!!----FAIL----!!!!!!----FAIL----!!!!!!----FAIL----!!!!!!----FAIL----!!!");
			System.out.println("------------------------------------------------------------------------");
        }

    }

    public static void main(String[] args) {
        testCase("construct queue, enqueue(item), toString()", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            a.enqueue(11);
            a.enqueue(22);
            a.enqueue(-17);
            System.out.println(a);
            assertion(a.toString().contains("11") && a.toString().contains("22") && a.toString().contains("-17"), a.toString());
        });
        testCase("size(), peekFront()", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();

            assertion (a.size() == 0, "a.asize() == 0");

            a.enqueue(11);
            assertion(a.size() == 1, "a.asize() == 1");
            assertion(a.peekFront() == 11, "a.peekFront() == 1");

            a.enqueue(22);
            assertion(a.size() == 2, "a.asize() == 2");
            assertion(a.peekFront() == 11, "a.peekFront() == 1");

            a.enqueue(-17);
            assertion(a.size() == 3, "a.asize() == 3");
            assertion(a.peekFront() == 11, "a.peekFront() == 1");
        });

        exceptTestCase("peekFront() on empty list", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            a.peekFront();
        });

        testCase("basic dequeue()", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            a.enqueue(1);
            a.enqueue(2);
            a.enqueue(3);
            System.out.println(a);
            assertion(a.size() == 3);
            assertion(a.dequeue() == 1, "a.dequeue() == 1");
            System.out.println(a);
            assertion(a.size() == 2);
            assertion(a.dequeue() == 2, "a.dequeue() == 2");
            System.out.println(a);
            assertion(a.size() == 1);
            assertion(a.dequeue() == 3, "a.dequeue() == 3");
            System.out.println(a);
            assertion(a.size() == 0);

        }); 
        
        exceptTestCase("dequeue() from empty list", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            a.dequeue();
            
        });
        
        testCase("enqueue() requiring expansion of internal array", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            for(int i = 0; i < 100; i++) {
                a.enqueue(i);
            }
            System.out.println(a);

            
            assertion(a.size() == 100,"a.size() == 100");
            assertion(a.peekFront() == 0,"a.peekFront() == 0");

            for(int i = 0; i < 50; i++) {
                assertion(a.dequeue() == i,"a.dequeue()=="+i);
            }
            System.out.println(a);
            assertion(a.size() == 50, "a.size() == 50");
            assertion(a.peekFront() == 50, "a.peekFront() == 50");
            System.out.println(a);
        });

        testCase("clear and isEmpty", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            a.enqueue(1);
            assertion(a.size() == 1);
            a.clear();
            assertion(a.size() == 0);
            assertion(a.isEmpty());
            a.enqueue(3);
            assertion(a.size() == 1);
            assertion(!a.isEmpty());
            assertion(a.peekFront() == 3);
            a.clear();
            assertion(a.size() == 0);
        });

        testCase("circular nature of queue", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            int eval = 10;
            int dval = 10;
            for (int i=0; i<10; i++)
            {
                for (int j=1; j<=10; j++)
                {
                    a.enqueue(eval);
                    eval += 10;
                    System.out.println(a);
                }
                for (int j=1; j<=8; j++)
                {
                    assertion(a.dequeue() == dval, a.toString());
                    dval += 10;
                    System.out.println(a);
                }
            }
        });
        testCase("circular nature of queue 2", () -> {
            LinkedListQueue<Integer> a = new LinkedListQueue<Integer>();
            a.enqueue(10);
            for (int i=1; i<=105; i++)
            {
                a.enqueue(a.dequeue());
                assertion(a.size() == 1);
            }
            System.out.println(a);
            a.enqueue(20);
            for (int i=1; i<=104; i++)
            {
                a.enqueue(a.dequeue());
                assertion(a.size() == 2);
            }
            System.out.println(a);
        });
    }
        
}