## 配置KVM虚拟机网络的两种方式（Bridge模式和NAT模式）

* Bridge原理(桥接模式)
    > Bridge方式即虚拟网桥的网络连接方式，使客户机和子网里面的机器能够互相通信。可以使虚拟机成为网络中具有独立IP的主机。
    桥接网络（也叫物理设备共享）被用作把一个物理设备复制到一台虚拟机。网桥多用作高级设置，特别是主机多个网络接口的情况。

    > 在bridged模式下，虚拟出来的操作系统就像是局域网中的一台独立的主机，它可以访问网内任何一台机器。同时，由于这个虚拟系统是局域网中的一个独立的主机系统，那么就可以手工配置它的TCP/IP配置信息，以实现通过局域网的网关或路由器访问互联网。使用bridged模式的虚拟系统和宿主机器的关系，就像连接在同一个Hub上的两台电脑。想让它们相互通讯，你就需要为虚拟系统配置IP地址和子网掩码，否则就无法通信（参考dhcp服务器是否开启，如果开启，则可以选择dhcp方式自动获取网络地址）。这种方式最简单，直接将虚拟网卡桥接到一个物理网卡上面，和linux下一个网卡绑定两个不同地址类似，实际上是将网卡设置为混杂模式，从而达到侦听多个IP的能力。在此种模式下，虚拟机内部的网卡（例如linux下的eth0)直接连到了物理网卡所在的网络上，可以想象为虚拟机和host机处于对等的地位，在网络关系上是平等的，没有谁在谁后面的问题。使用这种方式很简单，前提是你可以得到1个以上的地址。

    ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/libvirt-kvm-bridge-network.png "图片1")

    > 如上图，网桥的基本原理就是创建一个桥接接口br0，在物理网卡和虚拟网络接口之间传递数据。

    * 基本步骤<br>
        1. 安装完CentOS7.0， 在/etc/sysconfig/network-scripts/目录下面会生成两个默认网络配置文件。（如图）

            ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/2.png "图片1")
        2. 继续看文件里面的详细信息。
            * ifcfg-eth0</br>
            ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/1.png "图片1")
            * ifcfg-lo</br>
            ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/3.png "图片1")
        3. 配置静态IP
            * 在相同目录下面添加一个ifcfg-br0文件，并在文件中添加如下内容</br>
            ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/4.png "图片1")
            * 并且修改ifcfg-eth0文件</br>
            ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/5.png "图片1")
        4. 配置动态IP
            * 在相同目录下面添加一个ifcfg-br0文件，并在文件中添加如下内容
            ```xml
            DEVICE=br0
            TYPE=Bridge
            NM_CONTROLLED=no
            BOOTPROTO=dhcp
            ONBOOT=yes
            ```
            * 并且修改ifcfg-eth0文件</br>
            ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/5.png "图片1")
        5. 申明
* NAT原理(网络地址转换模式)

    > 使用NAT模式，就是让虚拟系统借助NAT(网络地址转换)功能，通过宿主机器所在的网络来访问公网。也就是说，使用NAT模式可以实现在虚拟系统里访问互联网。很显然，如果你只有一个外网地址，此种方式很合适。

    * virsh net-list
        >查看当前活跃的网络，可以看到一个default网络，这个就是一个默认的Nat网络了。

    * virsh net-dumpxml default
        >查看网络配置

        ![image](http://learningnotes-1251679769.costj.myqcloud.com/linux/default-nat.png "图片1")


#### 持续更新中......
-----

* REFERENCES

    1. <a href="https://www.chenyudong.com/archives/libvirt-kvm-bridge-network.html" target="\_blank">libvirt kvm 虚拟机上网 – Bridge桥接</a>
