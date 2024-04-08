class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ans = 0;
        int n = students.length;
        Queue<Integer> queue = new LinkedList<>(); 
        for(int student : students){
            queue.add(student);
        }
        int size = 0;
        int i = 0;
        while(queue.size() != 0){
            if(queue.peek() == sandwiches[i]){
                queue.remove();
                i++;
                size = 0;
                ans++;
            }
            else{
                queue.add(queue.remove());
                size++;
                if(size == queue.size()) break;
            }
        }
        return n - ans; 
    }
}
