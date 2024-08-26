 import java.awt.*;
 import java.awt.event.*;
 import java.util.ArrayList;
 import javax.swing.*;

public class Dinosaur extends JPanel implements ActionListener,KeyListener{
      int boardWidth=750;
      int boardHeight=250;

      Image dinosaurImg;
      Image dinosaurDeadImg;
      Image dinosaurJumpImg;
      Image cactus1Img;
      Image cactus2Img;
      Image cactus3Img;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    private void draw(Graphics g) {
        g.drawImage(dinosaur.img,dinosaur.x,dinosaur.y,dinosaur.width,dinosaur.height,null);
    }
    public void move(){
        velocityY+=gravity;
        dinosaur.y+=velocityY;
        if(dinosaur.y>dinosaurY){
            dinosaur.y =dinosaurY;
            velocityY=0;
            dinosaur.img=dinosaurImg;
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
           if(dinosaur.y==dinosaurY) {
               velocityY=-17;
           dinosaur.img=dinosaurJumpImg;}
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    class Block{
          int x;
          int y;
          int width;
          int height;
          Image img;

          Block(int x,int y,int width,int height,Image img){
              this.x=x;
              this.y=y;
              this.width=width;
              this.height=height;
              this.img=img;
          }
      }

      //характеристики динозаврика
      int dinosaurWidth=88;
      int dinosaurHeight=94;
      int dinosaurX=50;
      int dinosaurY=boardHeight-dinosaurHeight;

      Block dinosaur;

      //cactus

      //jumps
      int velocityY=0;//jump speed
      int gravity=1;
      Timer gameLoop;


      public Dinosaur(){
          setPreferredSize(new Dimension(boardWidth,boardHeight));
          setBackground(Color.lightGray);
          setFocusable(true);
          addKeyListener(this);
           // create icon
          dinosaurImg=new ImageIcon(getClass().getResource("./img/dino-run.gif")).getImage();
          dinosaurDeadImg=new ImageIcon(getClass().getResource("./img/dino-dead.png")).getImage();
          dinosaurJumpImg=new ImageIcon(getClass().getResource("./img/dino-jump.png")).getImage();
          cactus1Img=new ImageIcon(getClass().getResource("./img/cactus1.png")).getImage();
          cactus2Img=new ImageIcon(getClass().getResource("./img/cactus2.png")).getImage();
          cactus3Img=new ImageIcon(getClass().getResource("./img/cactus3.png")).getImage();

          //динозаврик
          dinosaur=new Block(dinosaurX,dinosaurY,dinosaurWidth,dinosaurHeight,dinosaurImg);
          //игровой цикл
          gameLoop=new Timer(1000/60,this);
          gameLoop.start();
      }






}
