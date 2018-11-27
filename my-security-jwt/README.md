    接下来说说非对称加密的token怎样产生和解析的,你可以使用jdk自带的keytool工具,注意配置好JAVA_HOME，
输入，如下内容
    keytool -genkey -alias jwt -keyalg  RSA -keysize 1024 -validity 365 -keystore jwt.jks

    意思是使用keytool生成密钥，别名为jwt，算法为RSA，有效期为365天，文件名为jwt,jks,把文件保存在当前打开cmd的路径下,它提示输入密码,我就输入lhc123吧
接下的输入用户，密码为12345可以忽略,回车pass
登录成功后下次请求 请求头中 加 Authorization=Bearer +返回的token
把生成的文件复制到resources目录下,写一个JwtTokenUtil 的生成和解析两个方法
---------------------
作者：lhc0512
来源：CSDN
原文：https://blog.csdn.net/lhc0512/article/details/80563160
版权声明：本文为博主原创文章，转载请附上博文链接！