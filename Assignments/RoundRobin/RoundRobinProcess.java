import java.util.*;
public class RoundRobinProcess {
    private Queue<Process> arrivalQueue; // Processes that haven't arrived yet
    private int quantumLength;

    // Helper class to track extra info per Process
    private static class ProcessInfo {
        Process process;
        int remainingTime;
        int completionTime = -1;
        int firstStartTime = -1;

        public ProcessInfo(Process process) {
            this.process = process;
            this.remainingTime = process.getExecutionTime();
        }
    }

    public RoundRobinProcess(Queue<Process> processQueue, int quantumLength) {
        this.arrivalQueue = processQueue;
        this.quantumLength = quantumLength;
    }

    public void runScheduler() {
        Queue<ProcessInfo> readyQueue = new Queue<>();
        List<ProcessInfo> completed = new ArrayList<>();
        Map<String, ProcessInfo> infoMap = new HashMap<>();

        // Extract all process info into a sorted list (by arrivalTime)
        List<Process> allProcesses = new ArrayList<>();
        while (!arrivalQueue.isEmpty()) {
            allProcesses.add(arrivalQueue.dequeue());
        }
        allProcesses.sort(Comparator.comparingInt(Process::getArrivalTime));

        // Reload arrivalQueue with sorted processes
        for (Process p : allProcesses) {
            arrivalQueue.enqueue(p);
            infoMap.put(p.getName(), new ProcessInfo(p));
        }

        int currentTime = 0;

        while (!arrivalQueue.isEmpty() || !readyQueue.isEmpty()) {
            // Enqueue processes that have arrived
            while (!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() <= currentTime) {
                Process arriving = arrivalQueue.dequeue();
                readyQueue.enqueue(infoMap.get(arriving.getName()));
            }

            if (readyQueue.isEmpty()) {
                currentTime++;
                continue;
            }

            ProcessInfo current = readyQueue.dequeue();

            if (current.firstStartTime == -1) {
                current.firstStartTime = currentTime;
            }

            int runTime = Math.min(quantumLength, current.remainingTime);
            System.out.println("Time " + currentTime + " to " + (currentTime + runTime) + ": " + current.process.getName());
            current.remainingTime -= runTime;
            currentTime += runTime;

            // Enqueue new arrivals during this time slice
            while (!arrivalQueue.isEmpty() && arrivalQueue.peek().getArrivalTime() <= currentTime) {
                Process arriving = arrivalQueue.dequeue();
                readyQueue.enqueue(infoMap.get(arriving.getName()));
            }

            if (current.remainingTime > 0) {
                readyQueue.enqueue(current);
            } else {
                current.completionTime = currentTime;
                completed.add(current);
                System.out.println("Process " + current.process.getName() + " completed at time " + currentTime);
            }
        }

        displayStats(completed);
    }

    public void displayStats(List<ProcessInfo> completedProcesses) {
        int totalWait = 0;
        System.out.println("\nProcess Stats:");
        for (ProcessInfo pInfo : completedProcesses) {
            int turnaroundTime = pInfo.completionTime - pInfo.process.getArrivalTime();
            int waitTime = turnaroundTime - pInfo.process.getExecutionTime();
            totalWait += waitTime;
            System.out.println(pInfo.process.getName() + ": Turnaround Time = " + turnaroundTime + ", Wait Time = " + waitTime);
        }
        double averageWait = (double) totalWait / completedProcesses.size();
        System.out.println("\nAverage Wait Time: " + averageWait);
    }

    public static void main(String[] args) {
        String filename = (args.length >= 1) ? args[0].trim() : "data.txt";
        RoundRobinReader rr = new RoundRobinReader(filename);

        Queue<Process> processQueue = rr.getProcessQueue();
        System.out.println("Process Queue: " + processQueue);
        int quantumLength = rr.getQuantumLength();
        System.out.println("Quantum Length: " + quantumLength);

        RoundRobinProcess rrp = new RoundRobinProcess(processQueue, quantumLength);
        rrp.runScheduler();
    }
}