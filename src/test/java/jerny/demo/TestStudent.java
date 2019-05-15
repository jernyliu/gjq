package jerny.demo;

import com.chinamobile.js.sz.tvms.GjqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GjqApplication.class)
public class TestStudent {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test(){
        Student s = studentMapper.getStudent(1);
        System.out.println(s);
    }
}
