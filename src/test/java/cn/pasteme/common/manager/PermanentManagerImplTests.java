package cn.pasteme.common.manager;

import cn.pasteme.common.mapper.PermanentMapper;
import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.manager.PermanentManager;

import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lucien, Irene
 * @version 1.1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PermanentManagerImplTests {

    @Autowired
    PermanentManager permanentManager;

    @Test
    public void main() {

    }
}
