package ScrappedCards;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import DsuperCard;
public class DCardIvy extends DsuperCard{
    private Image image;
    public DCardIvy(){
        super(2,3,4,5,"h","h","h","h",2, Health, Health, Health);
        try{
            image = ImageIO.read(new File("Ivy.jpg"));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void draw(Graphics window){
        window.drawImage(image,0,0,20,20,null);
    }
}
