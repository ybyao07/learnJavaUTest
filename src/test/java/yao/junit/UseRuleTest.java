package yao.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;

/**
 * @author yongboyao
 * create_date 2023/1/31$
 * @Description
 **/

public class UseRuleTest {
    @Rule
    public final TemporaryFolder tempFolder = new TemporaryFolder();
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void countsAssets() throws IOException {
        File icon = tempFolder.newFile("icon.png");
        File assets = tempFolder.newFolder("assets");
        createAssets(assets, 3);

//        DigitalAssetManager dam = new DigitalAssetManager(icon, assets);
//        assertEquals(3, dam.getAssetCount());
    }

    private void createAssets(File assets, int numberOfAssets) throws IOException {
        for (int index = 0; index < numberOfAssets; index++) {
            File asset = new File(assets, String.format("asset-%d.mpg", index));
            Assert.assertTrue("Asset couldn't be created.", asset.createNewFile());
        }
    }

    @Test
//    @Ignore
    public void throwsIllegalArgumentExceptionIfIconIsNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectCause(isA(NullPointerException.class));
        exception.expectMessage("This is illegal");

        throw new IllegalArgumentException("This is illegal", new NullPointerException());
    }
}
