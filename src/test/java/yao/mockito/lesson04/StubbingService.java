package yao.mockito.lesson04;

/**
 * @author yongboyao
 * create_date 2022/12/2$
 * @Description
 **/

public class StubbingService {
    public int getI(){
        System.out.println("====== geti====");
        return 10;
    }
    public String getS(){
        System.out.println("===== getS =====");
        throw new RuntimeException();
    }
}
