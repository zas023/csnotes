/*德才论

题目描述
宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之

小人。凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”



现给出一批考生的德才分数，请根据司马光的理论给出录取排名。

输入描述:
输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，即德分和才分均不低于L的考生才有资格

被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到

但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于H，但是德分不低于才分的考生属于“才德兼

亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三类考生之后。


随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，德才分为区间[0, 100]内的整数。数字间以空格分隔。


输出描述:
输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。当某类考生中有多人

总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。

输入例子:
14 60 80

10000001 64 90

10000002 90 60

10000011 85 80

10000003 85 80

10000004 80 85

10000005 82 77

10000006 83 76

10000007 90 78

10000008 75 79

10000009 59 90

10000010 88 45

10000012 80 100

10000013 90 99

10000014 66 60

输出例子:
12

10000013 90 99

10000012 80 100

10000003 85 80

10000011 85 80

10000004 80 85

10000007 90 78

10000006 83 76

10000005 82 77

10000002 90 60

10000014 66 60

10000008 75 79

10000001 64 90
*/

#include <iostream>
#include <set>

using namespace std;

class Student
{
public:
	int id,morality, ability;  //学生id,德，才
	int sum;   //学生总成绩
	int level; //学生等级，默认4等，不予录取

	Student(int id, int morality, int ability){
		this->id=id;
		this->morality=morality;
		this->ability=ability;
		this->sum = morality + ability;
		level=4;
	}

	//重载运算符 <
	bool operator < (const Student& other) const{
		if (level!=other.level){
			return level>other.level;
		}
		else if(sum != other.sum) {
			return other.sum>sum;
		} 
		else if(morality != other.morality) {
			return other.morality>morality;
		} else {
			return id>other.id;
		}
	}
};

int main()
{
    // 基本变量
	int N, L, H;
	cin >> N >> L >> H;

	set<Student> student;

	//接收学生集合并进行分类
	for (int i = 0; i < N; ++i)
	{
		int id, morality, ability;
		cin >> id >> morality >> ability;
		Student stu(id, morality, ability);

		if(morality<L || ability<L){
			continue;
		}
		if(morality>=H){
			if (ability>=H)
				stu.level=1;
			else
				stu.level = 2;
		}
		if (morality>=ability){
			stu.level = 3;
		}

		student.insert(stu);
	}

	// 输出结果
	cout << student.size() << endl;

	set<Student>::reverse_iterator iter;
	for(iter=student.rbegin(); iter != student.rend(); iter++) {
		cout << (*iter).id << " " << (*iter).morality << " " << (*iter).ability << endl;
	}

	return 0;
}