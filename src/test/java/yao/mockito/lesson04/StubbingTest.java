package yao.mockito.lesson04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * @author yongboyao
 * create_date 2022/12/2$
 * @Description
 **/

@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {
    private List<String> list;
    @Before
    public void init(){
        this.list = mock(ArrayList.class);
    }

    @Test
    public void howToUseStubbing(){
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));

        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        }catch (Exception e){
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }


    @Test
    public void howToStubbingVoidMethod(){
        doNothing().when(list).clear();
        list.clear();
        verify(list, times(1)).clear();

        doThrow(RuntimeException.class).when(list).clear();
        try {
            list.clear();
            fail();
        }catch (Exception e){
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void stubbingDoReturn(){
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);
        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void iterateSubbing(){
        when(list.size()).thenReturn(1,2,3,4);
        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void stubbingWithAnswer(){
        when(list.get(anyInt())).thenAnswer(invocationOnMock ->{
           Integer index = invocationOnMock.getArgument(0);
           return String.valueOf(index * 10);
        });
        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(999), equalTo("9990"));
    }
    @Test
    public void stubbingWithRecall(){
        StubbingService service = mock(StubbingService.class);
        System.out.println(service.getClass());

        when(service.getS()).thenReturn("Alex");
        assertThat(service.getS(), equalTo("Alex"));

        when(service.getI()).thenCallRealMethod();
        assertThat(service.getI(), equalTo(10));
    }
    @After
    public void destroy(){
        reset(this.list);
    }
}
