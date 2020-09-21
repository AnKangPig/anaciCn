import java.util.Scanner;
import zuo.zhe.shao.hua.anaciCn;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		// 从键盘接收数据
		System.out.print("输入数字：");
		// 判断是否还有输入
		if (scan.hasNextLine()) {
			String number = scan.nextLine();
			scan.close();
			//结束输入
			String ccnumber=anaciCn.arabicNumeralsAreConvertedIntoChineseNumerals(number);
			if(!("Errorone"/*使用保留字符（@）错误*/.equals(ccnumber)) &&
			   !("Errortwo"/*左起第一位为0（不包括整数位只有一位的）错误*/.equals(ccnumber)) &&
			   !("Errorthree"/*左起第一位为.错误*/.equals(ccnumber)) &&
			   !("Errorfour"/*输入非数字错误*/.equals(ccnumber)) &&
			   !("Errorfive"/*输入多个小数点错误*/.equals(ccnumber))){
				System.out.println(ccnumber);
			}
		}
	}
}
