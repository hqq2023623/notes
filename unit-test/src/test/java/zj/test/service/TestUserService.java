package zj.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import zj.service.UserService;
import zj.service.impl.UserFileServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by lzj on 2016/9/23.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserFileServiceImpl userFileService;

    private static List<String> users = new ArrayList<>();
    private static Map<String, List<String>> files = new HashMap<>();

    static {
        users.add("lzj");
        users.add("faker");
        List<String> list = new ArrayList<>();
        list.add("file1");
        files.put("lzj", list);
    }


//     不用@RunWith(MockitoJUnitRunner.class)就用initMocks
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }


    @Test
    public void testQueryAll() throws Exception {
        userService.queryAll();
        verify(userService).queryAll();
        reset(userService);

        when(userService.queryAll()).thenReturn(users);
        List<String> list = userService.queryAll();
        assertEquals(list.get(0), users.get(0));

    }

    @Test
    public void testListByUserId() throws Exception {
        when(userService.queryAll()).thenReturn(users);
        List<String> list = userService.queryAll();
        String id = list.get(0);
        List<String> strings = userFileService.listByUserId(id);
        assertEquals(1, strings.size());
    }


}
