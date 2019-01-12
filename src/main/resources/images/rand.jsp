<%@ page contentType="image/jpeg; charset=gb2312" import= "java.awt.*,java.util.*,java.awt.image.*,javax.imageio.*" %>
<%!
Color getcolor(int forecolor,int backcolor){
    Random random=new Random();
	if (forecolor>255) forecolor=255;
	if (backcolor>255) backcolor=255;
	int red=forecolor+random.nextInt(backcolor-forecolor);
	int green=forecolor+random.nextInt(backcolor-forecolor);
	int black=forecolor+random.nextInt(backcolor-forecolor);
	return new Color(red,green,black);
}
%>
<%
int width=60,height=20;
BufferedImage image =new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

Graphics grap=image.getGraphics();

Random random=new Random();

grap.setColor(getcolor(200,250));
grap.drawRect(0,0,width,height);

grap.setFont(new Font("Times New Roman",Font.PLAIN,18));

grap.drawRect(0,0,width-1,height-1);

grap.setColor(getcolor(180,250));
for(int i=0 ;i<200;i++){
	int x1=random.nextInt(width);
	int y1=random.nextInt(height);
	int x2=random.nextInt(12);
	int y2=random.nextInt(12);
	grap.drawLine(x1,y1,x2,y2);
}

String myRand="";
for (int i=0;i<=3;i++){
	int index=0;
	String sourcenum="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	index=(int)(Math.random()*100)%35;
	String rand=sourcenum.substring(index,index+1);
	myRand=myRand+rand;
	grap.setColor(new Color(10+random.nextInt(100),10+random.nextInt(100),10+random.nextInt(100)));
	grap.drawString(rand,13*i+6,16);
}
session.setAttribute("Rand",myRand);
grap.dispose();
ImageIO.write(image,"JPEG",response.getOutputStream());

%>

