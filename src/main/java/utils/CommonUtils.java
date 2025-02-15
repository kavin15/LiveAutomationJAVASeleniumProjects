package utils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtils 
{
	public static String generateBrandNewEmail()
	{
	    return new Date().toString().replaceAll(" ", "").replaceAll("\\:", "")+"@email.com"; //Method Channing  
	}
	
	public static boolean compareToScreenshot(String actualImgPath, String expectedImgPath) throws IOException 
	{
		BufferedImage actualImg = ImageIO.read(new File(actualImgPath));
		BufferedImage expectedImg = ImageIO.read(new File(expectedImgPath));
		ImageDiffer imgDiffer=new ImageDiffer();
		ImageDiff imageDiffer = imgDiffer.makeDiff(expectedImg, actualImg);
		return imageDiffer.hasDiff();
	}
}
