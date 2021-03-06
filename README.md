### Chapter1

1. 实现一个算法，确定字符串的所有字符是否全都不同。

 解题思想： 首先，需要确定是 `ASCII` 字符还是 `Unicode` 字符，假设是 `ASCII` 字符，可以先检测字符串长度是否大于 256， 如果大于就说明肯定存在相同的字符，否则声明一个容量为 256 的布尔数组，依次检测字符串的值并将对应下标的布尔数组置为 `true`，如果此时布尔数组的下标已经是 `true`，说明字符串中存在相同字符。
 
2. 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排序后，能否变成另一个字符串。 
 
 解题思想： 这题有两种解法，一种是利用 `Arrays.sort()` 对两个数组进行排序（在 Java 中需要先将字符串转换成字符数组，可调用字符串的 `toCharArray()` 方法）。第二种需要利用辅助数组（假设是 ASCII 字符），统计每个字符的出现次数，然后与第二个数组进行比较。
 
3. 编写一个方法，将字符串中的空格全都替换成 %20 ， 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的真实长度。
 
 解题思想： 首先，我们需要统计字符串中有多少个空格，这样我们就可以计算出数组的新长度，然后只需要从末尾开始检测数组，遇到空格就将 %20 插入即可。
  
4. 利用字符串重复的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串 "aabcccccaaa" 会变为 "a2b1c5a3"。若压缩后的字符串没有变短，则返回原来的字符串。

 解题思想： 这一题，首先检测是否有必要压缩代码。检测方法和压缩方法都是类似的，这段建议直接看源代码！

5. 假定有一个方法 isSubstring， 可检查一个单词是否为其它字符串的子串。给定两个字符串 s1 和 s2，请编写代码检查 s2 是否为 s1 旋转而成，要求只能调用一次 isSubstring(比如， waterbottle 是 erbottlewat 的字符串)。
 
 解题思想： s2 无论如何旋转始终是 s1s1 的子串。
 
 ---
 
### Chapter2
 
1. 编写代码，移除未排序链表中的重复节点。
 
 解题思想： 如果允许使用临时缓冲区，那么可以利用 Hashtable 来存储链表的各个元素，以去除重复节点，不过这要求节点的 key 是对象属性。如果不允许使用临时缓冲区，那么只能利用循环检测，此时时间复杂度为 O(N^2)。
 
2. 找出单链表中的倒数第 k 个节点。

 解题思想： 如果不要求返回节点元素，可以使用递归的方式，递归方法的思想就是遍历到链表的最后一个元素，然后开始计数，直到数值达到 k，由于此时是倒着计数的，所以这就是要找的倒数第 k 个节点。如果要求返回节点元素，那么就可以使用快行指针，思想就是设置两个指针，让两个指针间隔为 k-1， 这样的话，当快行指针到达尾部的时候，正常指针的位置正好到达倒数第k个节点。
 
3. 实现一个算法，删除单向链表中间的某个节点，假定你只能访问该节点。 示例： 输入单向链表 a->b->c->d->e 中的节点 c，不返回任何数据，但是链表变成 a->b->d->e

 解题思想： 因为只能访问要删除的节点，所以我们只需要将下一节点的信息都复制到当前节点即可。`c.data = c.next.data; c.next = c.next.next;` 不过在这之前，可以先检查以下 `c` 以及 `c.next` 是否为 `null`。值得注意的是，千万不要直接将解题方法想成了 `c = c.next`，因为这样我们只是将 `c` 节点的引用移到了下一节点而已，并没有删除掉节点。
 
4. 编写代码。以给定值 x 为基准将链表分割成两部分，所有小于 x 的借点排在大于等于 x 的节点之前。

 解题思想： 由于给定的条件是链表，链表的移动和删除开销是很小的，所以我们只需要在定义两个链表，将原链表中的值与 x 进行对比，小于 x 的放在前一个列表中，大于等于 x 的放在后一个列表中，在程序中定义了四个变量，分别是 beforeStart, beforeEnd, afterStart, afterEnd ,其中 beforeStart, afterStart 主要用于鉴别，方便使用。分割完之后，需要将两个链表整合后在返回，注意整合的时候需要判断前一个链表是否为空！
 
 ---
 
### Chapter3

1. 描述如何用一个数组来实现三个栈.

 解题思想：固定分割法，比如指定一个数组为 300 大小，那么 [0,99]，[100,199],[200, 299] 分别存放三个栈的数据，在插入的时候根据传入参数进行操作即可。
 
2. 请设计一个栈，除 pop 和 push 方法，还支持 min 方法，可返回栈元素中的最小值，push，pop和 min 三个方法的时间复杂度必须为 O(1)

 解题思想： 为了将插入和弹出的时间复杂度控制在 O(1)，采用前插法处理元素，为了将 min() 时间复杂度复杂度控制在 O(1)，定义一个保存 min 值的栈，每次插入元素时进行如下操作： 如果要插入元素的值小于栈顶元素，那么将这个元素入栈。 到最后这个保存min 值的栈实际上保存的是在每个时刻栈中的最小元素。
 
3. 实现一个 MyQueue 类，该类用两个栈来实现一个队列

 解题思想： 因为队列的特点是先进先出，而栈则相反是后进先出，所以我们可以用一个栈用来保存元素，然后将这个栈的元素再 pop 到另一个栈中，这样就符合队列的特点了。关键的就是在需要的时候再将栈中的元素一次性全部移动到另一个栈中！
 
4. 编写程序，按升序对栈进行排序（即最大元素位于栈顶）。最多只能使用额外的栈存放临时数据，但不得将元素复制在别的数据结构中（如数组）。该栈支持如下操作：push.pop.peek.isEmpty 

 解题思想： 我们将两个栈分为有序栈和无序栈，也就是说有序栈中的数都是按照升序排列的，这样的话当我们插入一个新的元素时，可分为三种情况：一，插入的元素是有序栈中的第一个元素，这时候直接将元素插入。二，插入的元素大于有序栈栈顶的元素，这时候也是直接将元素插入。三，插入的元素小于有序栈栈顶的元素，这个时候我们依次将有序栈中的元素弹出到无序栈中，直到有序栈的栈顶元素小于插入元素，将元素插入后，再依次将无序栈中的元素弹出到有序栈中即可。
