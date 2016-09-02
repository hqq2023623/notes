package recursive;

import java.util.ArrayList;
import java.util.List;

public class T {

	public static int tiers = 4; // tiers 层数
	private static List<String> pagoda1 = new ArrayList<String>(); // 静态指针
	private static List<String> pagoda2 = new ArrayList<String>();

	private static List<String> pagoda3 = new ArrayList<String>();

	// 映射,用来确定并打印塔的序号(使用角标),也可以使用 Map

	private static List[] mapping = { pagoda1, pagoda2, pagoda3 };

	public static void main(String[] args) {
		preparePagoda(pagoda1, tiers);
		System.out.println("初始状态：");
		printPagodas();
		hanoi(tiers, pagoda1, pagoda2, pagoda3);
		System.out.println("最后结果：");
		printPagodas();
	}

	// --准备盘子(添加-字符串) (源塔)上
	private static void preparePagoda(List<String> srcPagoda, int tiers) {

		// 用于拼装塔层的容器
		StringBuilder builder = new StringBuilder();

		// 源塔的每一层加盘子，从底层开始, i ‘代表’盘子的直径大小，等于组成盘子的"^"个数
		for (int i = tiers; i > 0; i--) {

			// 每一层由 2*tiers-1 个格子组成，代表盘子大小的"^"格子由空格隔开
			for (int k = 0; k < tiers - i; k++)
				builder.append(" "); // 盘子左边的空格，数量为 [2*tiers-1-(2*i-1)]/2 =
										// tiers-i, 右边相同
			for (int j = 1; j <= 2 * i - 1; j++) { // 盘子所占格数
				if (j % 2 == 1)
					builder.append("^"); // 间隔摆放

				else
					builder.append(" ");
			}
			for (int k = 0; k < tiers - i; k++)
				builder.append(" "); // 盘子右边的空格

			srcPagoda.add(builder.toString()); // 添加到塔上
			builder.delete(0, builder.length()); // 下一循环前清空容器
		}
	}

	// --打印塔的现状

	private static void printPagodas() {

		// 打印层数为三座塔-现状的最大高度
		int len = Math.max(pagoda1.size(),
				Math.max(pagoda2.size(), pagoda3.size()));
		// 用于-塔的空层显示

		StringBuilder spaces = new StringBuilder();
		spaces.append("-"); // --添加塔的左外框
		for (int i = 0; i < 2 * tiers - 1; i++)
			spaces.append(" "); // 空层显示用空格
		spaces.append("-\t"); // --添加塔的右外框和塔间间隔

		for (int i = len - 1; i >= 0; i--) { // 从顶层开始

			// 三座塔同一水平面的塔层放在同一行显示
			// 当某个塔不存在此层时，List.get(index)会抛角标越界异常，使用try-catch处理：此层显示一层空格
			try {
				System.out.print("-" + pagoda1.get(i) + "-\t");
			} catch (Exception e1) {
				System.out.print(spaces);
			}
			try {
				System.out.print("-" + pagoda2.get(i) + "-\t");
			} catch (Exception e) {
				System.out.print(spaces);
			}
			try {
				System.out.print("-" + pagoda3.get(i) + "-\t");
			} catch (Exception e) {
				System.out.print(spaces);
			}
			System.out.print("\r\n");
		}
	}

	// 这个方法(递归的核心方法)从指定的源塔上移动-指定数量的盘子-到指定的目标塔上

	public static void hanoi(int moveNum, List<String> from,
			List<String> middle, List<String> to) {
		if (moveNum == 1) { // 递归到移动一个盘子时，使用 move 方法
			moveTheTopOne(from, to);
			return;
		}

		// 将实现分为三步，一，将源塔底盘上方的所有盘子移至中间塔(递归)；二，将底盘移到目标塔；三，将中间塔上的所有盘子移到目标塔上(递归)。
		hanoi(moveNum - 1, from, to, middle);
		moveTheTopOne(from, to);
		hanoi(moveNum - 1, middle, from, to);
	}

	// 方法的名字就是他的作用
	private static void moveTheTopOne(List<String> from, List<String> to) {
		String theTopOne = from.remove(from.size() - 1);
		to.add(theTopOne);

		// 打印图形，每移动一下，打印图形显示
		System.out.println("********** print ***********\r\n");
		// 确定塔的序号
		int fromNum = 0, toNum = 0;
		for (int i = 0; i < mapping.length; i++) { // 遍历塔的数组

			if (mapping[i] == from) {
				fromNum = i + 1;
			}
			if (mapping[i] == to) {
				toNum = i + 1;
			}
		}
		System.out.println("从 " + fromNum + " 号塔往 " + toNum + " 号塔\r\n");

		printPagodas(); // 打印图形
	}

}
