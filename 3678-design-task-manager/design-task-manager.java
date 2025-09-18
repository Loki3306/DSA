import java.util.*;
class TaskManager {
static class Task {
int userId;
int taskId;
int priority;
Task(int u, int t, int p) {
userId = u;
taskId = t;
priority = p;
}
}
Map<Integer, Task> taskMap;
PriorityQueue<Task> pq;
public TaskManager(List<List<Integer>> tasks) {
taskMap = new HashMap<>();
pq = new PriorityQueue<>((a, b) -> {
if (a.priority != b.priority) return Integer.compare(b.priority, a.priority);
return Integer.compare(b.taskId, a.taskId);
});
for (List<Integer> t : tasks) {
int userId = t.get(0);
int taskId = t.get(1);
int priority = t.get(2);
Task task = new Task(userId, taskId, priority);
taskMap.put(taskId, task);
pq.offer(task);
}
}
public void add(int userId, int taskId, int priority) {
Task task = new Task(userId, taskId, priority);
taskMap.put(taskId, task);
pq.offer(task);
}
public void edit(int taskId, int newPriority) {
if (!taskMap.containsKey(taskId)) return;
Task old = taskMap.get(taskId);
Task updated = new Task(old.userId, taskId, newPriority);
taskMap.put(taskId, updated);
pq.offer(updated);
}
public void rmv(int taskId) {
taskMap.remove(taskId);
}
public int execTop() {
while (!pq.isEmpty()) {
Task top = pq.peek();
Task valid = taskMap.get(top.taskId);
if (valid != null && valid.priority == top.priority) {
pq.poll();
taskMap.remove(top.taskId);
return valid.userId; // <-- return current userId (fixed)
} else {
pq.poll();
}
}
return -1;
}
}

public class Main {
public static void main(String[] args) {
List<List<Integer>> init = new ArrayList<>();
init.add(Arrays.asList(1, 101, 8));
init.add(Arrays.asList(2, 102, 20));
init.add(Arrays.asList(3, 103, 5));
TaskManager tm = new TaskManager(init);
// We'll collect outputs in LeetCode style for the operations:
// ["TaskManager","add","edit","execTop","rmv","add","execTop"]
List<Object> outputs = new ArrayList<>();
outputs.add(null); // constructor result
tm.add(4, 104, 5); outputs.add(null);
tm.edit(102, 9); outputs.add(null);
int r1 = tm.execTop(); outputs.add(r1); // should be 2
tm.rmv(101); outputs.add(null);
tm.add(50, 101, 8); outputs.add(null);
int r2 = tm.execTop(); outputs.add(r2); // should be 50
System.out.println(outputs); // prints: [null, null, null, 2, null, null, 50]
}
}
