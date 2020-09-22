package zuo.zhe.shao.hua;

public class anaciCn{
/**
阿拉伯数字转汉字数字v1.0
作者：不负韶华
使用方法:
1.通过import zuo.zhe.shao.hua.anaciCn;导入此类。
2.使用arabicNumeralsAreConvertedIntoChineseNumerals(你想转化的数字)来转化。
ps.注意，要导入字符串，想导入int，lang，float，double数字，请先转化成字符串。
请勿调用four和library方法。
*/

	public static String arabicNumeralsAreConvertedIntoChineseNumerals(String number) {
		char[] numberchar;
		char[] cci/*Chinese character integer*/;
		char[] ccd/*Chinese character decimal*/;
		String[] numberstring;
		String[] fccstring/*four Chinese character string*/;
		String ccnumber/*Chinese character number*/ = "";
		String ccnumberi/*Chinese character number integer*/ = "";
		String ccnumberd/*Chinese character number decimal*/ = "";
		String ttaahm/*ten thousand and one hundred million*/ = "";
		int hdp/*have decimal point*/ = 0;
		int podp/*position of decimal point*/ = number.indexOf(".");
		if(podp != -1){
		if (podp/4*4 == podp){//判断是否是4的倍数
			numberchar = new char[number.length()];
		}else{
			numberchar = new char[(4-(podp%4))+number.length()];
		}
		numberstring = new String[podp/4];
		fccstring = new String[podp/4];
		}else{
		if (number.length()/4*4 == number.length()){//判断是否是4的倍数
			numberchar = new char[number.length()];
		}else{
			numberchar = new char[number.length()+(4-(number.length()%4))];
		}
		numberstring = new String[numberchar.length/4];
		fccstring = new String[numberchar.length/4];
	}
	//初始化变量
				
	for(int i = 0;i < numberstring.length;i++){
		numberstring[i]="";
	}
	//将数组每一个量都变成空白而不是null
	if (number.indexOf("@") != -1){
			System.err.println("@ is reserved character!");
			return "Errorone";
		    //判断是否有本程序保留字符@，有就报错并退出
		}
		for(int i = 0;i < numberchar.length-number.length();i++){
			numberchar[i]='@';
		}
		//填充@
		if (number.charAt(0) == '0'){
			if(podp != -1){
				if(number.length()-(number.length()-podp) != 1){
					System.err.println("If there is more than one digit before the decimal point, the first digit from the left cannot be zero.");
					return "Errortwo";
				}
			}else{
				if(number.length() != 1){
					System.err.println("If there is more than one digit before the decimal point, the first digit from the left cannot be zero.");
					return "Errortwo";
				}
			}
		}
		//检测左起第一位是否为0，是就报错并退出(如果小数点前只有一个零就不报退)
		if (number.charAt(0) == '.'){
			System.err.println("The first digit from the left cannot be .!");
			return "Errorthree";
		}
		//检测左起第一位是否为.，是就报错并退出
	
		for(int i = numberchar.length-number.length(),h = 0;h < number.length();i++,h++){
			numberchar[i] = number.charAt(h);
		}
		//将number拆成字符数组
		
		
		for(int i = 0;i < numberchar.length;i++){
			if (!(numberchar[i] == '0'||
				  numberchar[i] == '1'||
				  numberchar[i] == '2'||
				  numberchar[i] == '3'||
				  numberchar[i] == '4'||
				  numberchar[i] == '5'||
				  numberchar[i] == '6'||
				  numberchar[i] == '7'||
				  numberchar[i] == '8'||
				  numberchar[i] == '9'||
				  numberchar[i] == '.'||
				  numberchar[i] == '@')){
				System.err.println("It is not a number!");
				return "Errorfour";
			}
		//判断数字里有没有除数字和小数点外的字符，有就报错并退出
			if(numberchar[i] == '.'){
				podp = i;
				hdp++;
			}//判断是否有小数点，有则重新定位podp并使hdp自增
		}
		if (hdp > 1){
			System.err.println("There can only be one decimal point!");
			return "Errorfive";
		}
		//判断是否有多个小数点，有就报错并退出
	
		if (podp != -1){
			//有小数点应该执行的
			cci=new char[podp];
			ccd=new char[numberchar.length-podp-1];
			//初始化变量
			for(int i = 0;i < podp;i++){
			cci[i] = numberchar[i];
			}
			for(int i=podp+1,h=0;i<numberchar.length;i++,h++){
				ccd[h] = numberchar[i];
			}
			//将数字分为整数和小数两部分。
			for(int i = 0,h = 0;i < numberstring.length;i++){
					for(int g = 0;g < 4;g++,h++){
						if(g == 3){//判断g是否为3
							numberstring[i] = numberstring[i] + String.valueOf(cci[h]);
							//如果是则后面不加,
						}else{
							numberstring[i] = numberstring[i] + String.valueOf(cci[h]) + ",";
							//如果不是则后面加,
						}
						//将字符数组4个4个放入字符串数组
					}
				}
				for(int i = 0,h = numberstring.length-1;i < numberstring.length;i++,h--){
					fccstring[h] = four(numberstring[i]);
				}
				//将汉字化的四位数放入fccstring
				for(int i = 0;i < fccstring.length;i++){
					if(i/2*2 == i && i != 0){//判断i是否是2的倍数以及是不是0
						ttaahm = ttaahm.replaceAll(library("w"),library("y"));
						//如果是2的倍数但不是0，那么把ttaahm里的library("w")换成library("y")
					}else{
						if(i != 0){
							ttaahm = library("w")+ttaahm;
							//如果不是2的倍数，那么往ttaahm里添加一个library("w")
						}
					}
					if(fccstring[i] == library("0")){
						ccnumberi = ccnumberi+fccstring[i];
					}else{
						ccnumberi = fccstring[i]+ttaahm+ccnumberi;
					}
					//将所有汉字四位整数连接起来
				}
				while (true){
					if(ccnumberi.charAt(ccnumberi.length()-1) == library("0").charAt(0)){
						ccnumberi = ccnumberi.substring(0, ccnumberi.length()-1);
					}else if (ccnumberi.indexOf(library("0")+library("0")) != -1) {
						ccnumberi = ccnumberi.replaceAll(library("0")+library("0"),library("0"));
					}else{
						break;
					}
				//去掉结尾的零，并把多个零替换成一个。
				}
				for (int i = 0;i < ccd.length;i++){
					ccnumberd = ccnumberd+library(String.valueOf(ccd[i]));
				}
				//将所有汉字化的小数连接起来。
				ccnumber = ccnumberi+library(".")+ccnumberd;
				//将整数和小数连接起来
				return ccnumber;
				//输出结果
					
			} else {
				//没有小数点应该执行的
			
				for(int i = 0,h = 0;i < numberstring.length;i++){
				for(int g = 0;g < 4;g++,h++){
						if(g == 3){//判断g是否为3
							numberstring[i] = numberstring[i] + String.valueOf(numberchar[h]);
							//如果是则后面不加,
						}else{
							numberstring[i] = numberstring[i] + String.valueOf(numberchar[h]) + ",";
							//如果不是则后面加,
						}
						//将字符数组4个4个放入字符串数组
					}
				}
				for(int i = 0,h = numberstring.length-1;i < numberstring.length;i++,h--){
					fccstring[h] = four(numberstring[i]);
				}
				//将汉字化的四位数放入fccstring
				for(int i = 0;i < fccstring.length;i++){//判断i是否是2的倍数以及是不是0
					if(i/2*2 == i && i != 0){
						ttaahm = ttaahm.replaceAll(library("w"),library("y"));
						//如果是2的倍数但不是0，那么把ttaahm里的library("w")换成library("y")
					}else{
						if(i != 0){
							ttaahm = library("w")+ttaahm;
							//如果不是2的倍数，那么往ttaahm里添加一个library("w")
						}
					}
					if(fccstring[i] == library("0")){
						ccnumber = fccstring[i]+ccnumber;
					}else{
						ccnumber = fccstring[i]+ttaahm+ccnumber;
					}
					//将所有汉字四位整数连接起来
				}
				while (true){
					if(ccnumber.charAt(ccnumber.length()-1) == library("0").charAt(0)){
						ccnumber = ccnumber.substring(0, ccnumber.length()-1);
					}else if (ccnumber.indexOf(library("0")+library("0")) != -1) {
						ccnumber = ccnumber.replaceAll(library("0")+library("0"),library("0"));
					}else{
						break;
					}
				}
				//去掉结尾的零，并把多个零替换成一个。
				return ccnumber;
				//输出结果
			}
		}
	public static String four(String num) {
		String fcc = "";
		String[] a = num.split(",");
		if("@".equals(a[0])){
			if("@".equals(a[1])){
				if("@".equals(a[2])){
					if("0".equals(a[3])){//0为0，1为除0外所有数字
						fcc = library("0");
						//@@@0
					}else{
						fcc = library(a[3]);
						//@@@1
					}
				}else{
					if("0".equals(a[3])){
						if("1".equals(a[2])){
							fcc = library("s");
						}else{
							fcc = library(a[2])+library("s");
						}
						//@@10
					}else{
						if("1".equals(a[2])){
							fcc = library("s")+library(a[3]);
						}else{
							fcc = library(a[2])+library("s")+library(a[3]);
						}
						//@@11
					}
				}
			}else{
				if("0".equals(a[2])){
					if("0".equals(a[3])){
						fcc = library(a[1])+library("b");
						//@100
					}else{
						fcc = library(a[1])+library("b")+library("0")+library(a[3]);
						//@101
					}
				}else{
					if("0".equals(a[3])){
						fcc = library(a[1])+library("b")+library(a[2])+library("s");
						//@110
					}else{
						fcc = library(a[1])+library("b")+library(a[2])+library("s")+library(a[3]);
						//@111
					}
				}
			}
		}else{
			if ("0".equals(a[0])){
				if ("0".equals(a[1])){
					if ("0".equals(a[2])){
						if ("0".equals(a[3])){
							fcc = library("0");
							//0000
						}else{
							fcc = library("0")+library(a[3]);
							//0001
						}
					}else{
						if ("0".equals(a[3])){
							fcc = library("0")+library(a[2])+library("s");
							//0010
						}else{
							fcc = library("0")+library(a[2])+library("s")+library(a[3]);
							//0011
						}
					}
				}else{
					if ("0".equals(a[2])){
						if ("0".equals(a[3])){
							fcc = library("0")+library(a[1])+library("b");
							//0100
						}else{
							fcc = library("0")+library(a[1])+library("b")+library("0")+library(a[3]);
							//0101
						}
					}else{
						if ("0".equals(a[3])){
							fcc = library("0")+library(a[1])+library("b")+library(a[2])+library("s");
							//0110
						}else{
							fcc = library("0")+library(a[1])+library("b")+library(a[2])+library("s")+library(a[3]);
							//0111
						}
					}
				}
			}else{
				if ("0".equals(a[1])){
					if ("0".equals(a[2])){
						if ("0".equals(a[3])){
							fcc = library(a[0])+library("q");
							//1000
						}else{
							fcc = library(a[0])+library("q")+library("0")+library(a[3]);
							//1001
						}
					}else{
						if ("0".equals(a[3])){
							fcc = library(a[0])+library("q")+library("0")+library(a[2])+library("s");
							//1010
						}else{
							fcc = library(a[0])+library("q")+library("0")+library(a[2])+library("s")+library(a[3]);
							//1011
						}
					}
				}else{
					if ("0".equals(a[2])){
						if ("0".equals(a[3])){
							fcc = library(a[0])+library("q")+library(a[1])+library("b");
							//1100
						}else{
							fcc = library(a[0])+library("q")+library(a[1])+library("b")+library("0")+library(a[3]);
							//1101
						}
					}else{
						if ("0".equals(a[3])){
							fcc = library(a[0])+library("q")+library(a[1])+library("b")+library(a[2])+library("s");
							//1110
						}else{
							fcc = library(a[0])+library("q")+library(a[1])+library("b")+library(a[2])+library("s")+library(a[3]);
							//1111
						}
					}
				}
			}
		}
		return fcc; 
	}
	public static String library(String num) {
		String lib = "";
		if("0".equals(num)){lib = "零";}
		if("1".equals(num)){lib = "一";}
		if("2".equals(num)){lib = "二";}
		if("3".equals(num)){lib = "三";}
		if("4".equals(num)){lib = "四";}
		if("5".equals(num)){lib = "五";}
		if("6".equals(num)){lib = "六";}
		if("7".equals(num)){lib = "七";}
		if("8".equals(num)){lib = "八";}
		if("9".equals(num)){lib = "九";}
		if("s".equals(num)){lib = "十";}
		if("b".equals(num)){lib = "百";}
		if("q".equals(num)){lib = "千";}
		if(".".equals(num)){lib = "点";}
		if("w".equals(num)){lib = "万";}
		if("y".equals(num)){lib = "亿";}
		return lib; 
	}
}
