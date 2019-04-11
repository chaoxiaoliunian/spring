import org.xml.sax.SAXException;
import sjqi.impl.ClassPathResource;
import sjqi.impl.XmlBeanFactory;
import sjqi.interf.BeanFactory;
import sjqi.interf.Resource;
import sjqi.model.User;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName TestSpring
 * @Description TODO
 * @Author sjqi
 * @Date 15:02 2019/3/28
 * @Version 1.0
 **/
public class TestSpring {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        //1.建立内存=文件映射
        Resource resource = new ClassPathResource("spring-config.xml");
        System.out.println("成功把文件映射到内存中，路径：" + resource.getFile().getAbsolutePath());
        //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder builder = factory.newDocumentBuilder();
        //Document doc = builder.parse(new FileInputStream(resource.getFile()));
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User user = (User) beanFactory.getBean("user");
        //TODO:完成依赖注入，postProcess等功能。
        System.out.println(user.getAge());

    }

    public void readFile(File file) {
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
