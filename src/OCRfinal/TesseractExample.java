package OCRfinal;


import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample
{
    public static void main(String[] args) {
       // File imageFile = new File("samples/phonetest6.png");
        OCR_prepocess Op = new OCR_prepocess();
        //�̹��� ��ó��
        Op.OCR_prepocess("phonetest5.jpg", "bitest5");
       // String resizeimageFile = 
        //��ó���� �̹������� �� �־��ֱ�
        File resizeimageFile = new File("bitest5.jpg"); /////////
		Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
		instance.setDatapath("/tessdata"); /////////
		instance.setLanguage("arial");
		//String x[]={"1x","2x","3x","4x"};
		
		//instance.setLanguage("o");
        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
		  System.out.println(resizeimageFile.canRead());
        try {
        	int i,j;
        	char c;
            String result = instance.doOCR(resizeimageFile); //ó����
            String result2 =""; //�����
           System.out.print(result);
            //test4.jpg �߸�
            if (result.indexOf("0��")>=0){ 
            result2=result.replace("0��","");	
          	result2= result2.replace(result2,result2+"from 0 to ��");}
            //test3.jpg x^2�϶�
            if(result.indexOf("x"+2)>=0){
          	 result2=result.replace("x"+2,"x��");
            }
            
            //x^n������ test3.jpg
//            for(i=2; i<100; i++){ 
//           	if(result.indexOf("x"+i)>=0){
//               	 result2=result.replace("x"+i,"x^"+i);
//           	}}
            
//          //�����Ⱑ z�γ��ͼ� /�� ġȯ
//           if (result.indexOf("z")>=0){ 
//            	result= result.replace("z","/");}
//           //x���ִ� �����ĵ��� solve ���ֱ�
//             if(result.indexOf("x")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"x"+"]"); 
//               }
//             //x^n�� ������ solve
//             for(i=2; i<100; i++){ 
//            	if(result.indexOf("x"+i)>=0){
//                	 result2=result.replace("x"+i,"x^"+i);
//                     result2=result2.replace("=","==");
//                  	 result2=result.replace(result,"Solve"+"["+result2+","+"x"+"]"); 
//            	    	}
//                 	}
//            //sinx �����ĵ� solve
//             if(result.indexOf("sinx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"sinx"+"]"); 
//               }
//             //cosx ������ solve
//             if(result.indexOf("cosx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"cosx"+"]"); 
//               }
//             //tanx ������ solve
//             if(result.indexOf("tanx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"tanx"+"]"); 
//               }
//             
//             //Integrate // dx��  //��������
//                 if(result.indexOf("Integrate")>=0){
//            	 result2=result.replace("Integrate","Integrate[");
//            	 if (result2.indexOf("dx")>=0){ //dx�� ������ dx�� ]�� ġȯ�ض�
//                 	result2= result2.replace("dx",","+"x"+"]");}
//            	//sin(x)�ϰ��
//                 if(result.indexOf("sin(x)")>=0){
//                	 result2=result2.replace("sin(x)","Sin[x]");
//                  	                }
//                //cos(x)�ϰ��
//                 if(result.indexOf("cos(x)")>=0){
//                	 result2=result2.replace("cos(x)","Cos[x]");
//                  	                }
//                 //tan(x)�ϰ��
//                 if(result.indexOf("tan(x)")>=0){
//                	 result2=result2.replace("tan(x)","Tan[x]");
//                  	                }
//            	 //���� ���� ���~
//            	  for(j=-100;j<100; j++){
//            		 for(i=-100;i<100; i++){
//            			 if(result2.indexOf("]"+"\n"+j)>=0 && result2.indexOf(i+"\n"+"Integrate")>=0)
//            			 { result2=result2.replace(i+"\n"+"Integrate","Integrate");
//                    	   result2=result2.replace("]"+"\n"+j,"]");
//                    	   result2=result2.replace(",x",","+"{x,"+j+","+i+"}");
//                    		 }
//                 	 	}
//            	 }
//            	 
//            	 
//             }
             //������ Integrate ��  ��  dx �������ڿ�
             //if(result.indexOf("^4")>=0){ 
           // 	 result2=result.replace("^4","4��");}//������ �׳��غ���
            // if(result.indexOf("Integrate")>=0){
            //	 result2=result.replace("Integrate","integrate[");  }
             
           //  for(i=0; i<100; i++){ // 1x~100x�ΰ͵� (1x)~(100x)�� ġȯ
           //  if(result.indexOf(i+"x")>=0){
           // 	 result2=result.replace(i+"x","("+i+"x)"); 
            // }
            // }
                     //��Ģã��
                          
            System.out.print(result2);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
