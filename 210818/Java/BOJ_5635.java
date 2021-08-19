import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String str;
        int a,b,c;
        List<Student> stus = new ArrayList<Student>();
        for(int i=0; i<N; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sum = c*10000 + b*100 + a;
            stus.add(new Student(sum, str));
        }
        
        Collections.sort(stus, Comparator.comparingInt(t -> t.birth));
        
        /*
        Collections.sort(stus, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Integer.compare(a.birth, b.birth);
            }
        });
        */

        System.out.println(stus.get(N-1).name);
        System.out.println(stus.get(0).name);
    }
}

class Student {
    public int birth;
    public String name;

    public Student(int birth, String name){
        this.birth = birth;
        this.name = name;
    }
}