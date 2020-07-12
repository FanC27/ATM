import java.util.*

fun main(){
    //登录
    login()
}

//设置初始金额
var FirstMoney = 0
var scanner = Scanner(System.`in`)

fun login(){
    //定义密码
    val password = 123456
    //初始登录界面
    println("欢迎宁！请输入密码：")

    var inputPwd = scanner.nextInt()
    //判断密码是否正确
    for (i in 3 downTo 1 step 1){
        if (inputPwd != password){
            println("密码错误，你还有($i)次机会，请重新输入：")
            inputPwd = scanner.nextInt()
        }else{
            println("密码正确！进入菜单界面：")
            menu()
            chooseJob()
            break
        }
    }
}

fun menu(){
    //菜单界面
    println("***************")
    println("*    1.存款    *")
    println("*    2.取款    *")
    println("*   3.查询余额  *")
    println("*    4.退出    *")
    println("***************")
}

fun chooseJob(){
    //进行菜单选择任务
    var chooseNum = 0
    chooseNum = scanner.nextInt()
    when(chooseNum){
        1 -> depositMenu()
        2 -> withdrawalMenu()
        3 -> balanceMenu()
        else -> print("感谢使用，您的账号已退出！")
    }
}

fun depositMenu(){
    //存款界面
    print("请输入存款金额：")
    val depositMoney = scanner.nextInt()
    FirstMoney += depositMoney
    println("存款成功！返回菜单界面")
    menu()
    chooseJob()
}

fun withdrawalMenu(){
    //取款界面
    print("请输入取款金额：")
    var withdrawalMoney = scanner.nextInt()
    //判断账户余额是否充足
        if (FirstMoney - withdrawalMoney < 0){
            //余额不足
            println("账户余额不足，请重新操作！")
            menu()
            chooseJob()
        }else{
            //取款成功
            println("取款成功！返回菜单界面")
            FirstMoney -= withdrawalMoney
            menu()
            chooseJob()
        }
}

fun balanceMenu(){
    println("您目前的账户余额为：$FirstMoney,返回菜单界面")
    menu()
    chooseJob()
}