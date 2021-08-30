package com.kulun.energynet.login;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import com.kulun.energynet.R;
import com.kulun.energynet.databinding.ActivityUserProtocolBinding;
import com.kulun.energynet.main.BaseActivity;

/**
 * created by xuedi on 2019/9/6
 */
public class UseProtocolActivity extends BaseActivity {
    private ActivityUserProtocolBinding binding;
    @Override
    public void initView(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_user_protocol);
        binding.header.title.setText("用户服务协议");
        binding.header.left.setOnClickListener(view -> finish());
        String message =
               "1 特别提示\n" +
                       "1.1  本《库仑能网换电宝用户服务协议》（以下简称《协议》）是服务使用人（以下简称“用户”）与库仑能网科技发展有限公司（以下简称“库仑”）之间关于用户下载、安装、使用“库仑能网换电宝”软件，注册、使用、管理“库仑能网换电宝”帐号，以及使用库仑提供的相关服务所订立的协议。\n" +
                       "1.2  库仑在此特别提醒您在注册成为用户之前，请认真阅读本协议，确保您充分理解本协议中各条款。除非您接受本协议所有条款，否则您无权注册、登录或使用本协议所涉服务。您的注册、登录、使用等行为将视为对本协议的接受，并同意接受本协议各项条款的约束。本协议可由库仑随时更新，更新后的协议条款一旦公布即代替原来的协议条款，恕不再另行通知，用户可在网站查阅最新版协议条款。在库仑修改协议条款后，如果用户不接受修改后的条款，请立即停止使用库仑提供的服务，用户继续使用库仑提供的服务将被视为接受修改后的协议。\n" +
                       "2\t账户注册\n" +
                       "2.1  用户在使用本服务前需要注册一个“库仑能网换电宝”帐号。“库仑能网换电宝”帐号应当使用手机号码绑定注册，请用户使用尚未与“库仑能网换电宝”帐号绑定的手机号码，以及未被库仑根据本协议封禁的手机号码注册“库仑能网换电宝”帐号。库仑可以根据用户需求或产品需要对帐号注册和绑定的方式进行变更，而无须事先通知用户。\n" +
                       "2.2  “库仑能网换电宝”系基于地理位置的新能源汽车换电产品，用户注册时应当授权库仑使用其地理位置信息方可成功注册“库仑能网换电宝”帐号。故用户完成注册即表明用户同意库仑提取及使用用户的地理位置信息。\n" +
                       "3\t服务内容\n" +
                       "3.1   “库仑能网换电宝”服务的具体内容由库仑根据实际情况提供，主要包括用户的注册登录、换电站导航、预约换电、到站扫码换电、评价、查询记录等。其中到站扫码换电费用，按照司机默认车辆车型计算，司机扫码前需确认默认车辆信息。库仑可以对其提供的服务予以变更，且库仑提供的服务内容可能随时变更；用户将会收到库仑关于服务变更的通知。\n" +
                       "3.2  库仑提供的服务包含免费服务与收费服务。用户可以通过付费方式购买收费服务，具体方式为：用户通过支付宝或微信支付。对于收费服务，库仑会在用户使用之前给予用户明确的提示，只有用户根据提示确认其同意按照前述支付方式支付费用并完成了支付行为，用户才能使用该等收费服务。支付行为的完成以第三方支付平台生成“支付已完成”的确认通知为准。\n" +
                       "4\t用户个人信息保护\n" +
                       "4.1  用户在注册帐号或使用本服务的过程中，可能需要填写或提交一些必要的个人信息，如法律法规、规章规范性文件（以下称“法律法规”）规定的需要填写的身份信息。如用户提交的信息不完整或不符合法律法规的规定，则用户可能无法使用本服务或在使用本服务的过程中受到限制。\n" +
                       "4.2  库仑在用户注册、使用本服务时收集的个人隐私信息：\n" +
                       "1)\t个人信息：例如手机号、真实姓名、身份证号等信息。\n" +
                       "2)\t支付：用户在“库仑能网换电宝”上支付时，可以选择第三方支付机构（如微信支付、支付宝）所提供的支付服务。支付功能本身并不收集您的个人信息，但我们需要将用户的订单信息及对账信息与这些支付机构共享以确认用户的支付指令并完成支付。\n" +
                       "3)\t客服：当用户与客服取得联系时，系统可能会记录用户与客服之间的通讯记录，以及使用用户的账号信息以便核验身份；当用户需要客服协助修改有关信息时，可能还需要提供上述信息外的其他信息以便完成修改。\n" +
                       "4)\t位置信息：为了便捷用户发现周边的换电站和预约时推荐换电站，库仑会基于用户的地理位置提供服务（LBS）。当用户开启设备定位功能并使用LBS时，库仑可能会收集和使用用户的位置信息，以实现用户查询周边换电站和预约的目的。\n" +
                       "5)\t设备信息：系统可能会根据用户在软件安装及使用中的具体权限，接收并记录用户在接受服务过程中使用的相关设备信息，例如设备型号、唯一设备标识符、操作系统、分辨率、电信运营商等软硬件信息等。\n" +
                       "4.3  库仑未经用户同意不得向任何第三方公开、透露用户个人隐私信息。但以下特定情形除外：\n" +
                       "1)\t库仑根据法律法规规定或有权机关的指示提供用户的个人隐私信息；\n" +
                       "2)\t由于用户将其账户密码告知他人或与他人共享注册帐户与密码，由此导致的任何个人信息的泄漏，或其他非因库仑原因导致的个人隐私信息的泄露；\n" +
                       "3)\t用户自行向第三方公开其个人隐私信息；\n" +
                       "4)\t用户与库仑及合作单位之间就用户个人隐私信息的使用公开达成约定，库仑因此向合作单位公开用户个人隐私信息；\n" +
                       "5)\t任何由于黑客攻击、电脑病毒侵入及其他不可抗力事件导致用户个人隐私信息的泄露；\n" +
                       "6)\t用户个人信息已经经过处理无法识别特定个人且不能复原。\n" +
                       "4.4  用户同意库仑可在以下事项中使用用户的个人隐私信息：\n" +
                       "1)\t库仑向用户及时发送重要通知，如软件更新、本协议条款的变更；\n" +
                       "2)\t库仑内部进行审计、数据分析和研究等，以改进库仑的产品、服务和与用户之间的沟通；\n" +
                       "3)\t依本协议约定，库仑管理、审查用户信息及进行处理措施；\n" +
                       "4)\t适用法律法规规定的其他事项。\n" +
                       "5\t使用规则\n" +
                       "5.1  用户在申请使用“库仑能网换电宝”服务时，必须向库仑提供准确、真实的个人相关资料，且需要通过库仑的认证后方能开始使用软件。如个人资料有任何变动，必须及时更新。更新过程中，库仑有权暂停该用户的使用权，经过库仑对更新信息的再次认证后方能继续使用软件。\n" +
                       "5.2  用户不应将其帐号、密码转让或出借予他人使用。如用户发现其帐号遭他人非法使用，应立即通知库仑。因黑客行为或用户的保管疏忽导致帐号、密码遭他人非法使用的，库仑不承担任何责任。同时，库仑保留在任何时候收回“库仑能网换电宝”帐号的权利。\n" +
                       "5.3  库仑拥有“库仑能网换电宝”的所有权或使用权、以及许可用户使用换电站及电池的权利，并负责换电站及电池的日常投放、保养、维修。同时，“库仑能网换电宝”服务系统的所有权及一切知识产权归库仑所有。\n" +
                       "5.4  用户在使用“库仑能网换电宝”服务过程中，必须遵循以下原则：\n" +
                       "1)\t遵守中国有关的法律和法规；\n" +
                       "2)\t遵守所有与本服务有关的网络协议、规定和程序；\n" +
                       "3)\t不得为任何非法目的而使用本服务系统；\n" +
                       "4)\t不得以任何形式使用“库仑能网换电宝”服务侵犯库仑的商业利益和进行不利于库仑的行为，包括但不限于发布非经库仑许可的商业或非商业广告；\n" +
                       "5)\t不得利用“库仑能网换电宝”服务系统进行任何可能对互联网或移动网正常运转造成不利影响的行为；\n" +
                       "6)\t不得利用本产品提供的服务展示或传播任何虚假的、骚扰性的、中伤他人的、辱骂性的、恐吓性的、庸俗淫秽的、或者其他任何违反公序良俗或非法的信息资料；\n" +
                       "7)\t不得侵犯其他任何第三方的专利权、著作权、商标权、名誉权或其他任何合法权益。\n" +
                       "6\t免责声明\n" +
                       "6.1  用户明确同意其使用本服务所存在的风险将完全由其自己承担；因其使用本服务而产生的一切后果也由其自己承担，除本协议另有约定外，库仑对用户不承担任何责任。\n" +
                       "6.2  库仑对本服务不作任何类型的担保，包括但不限于本服务的及时性、安全性、准确性，对在任何情况下因使用或不能使用本服务所产生的直接、间接、偶然、特殊及后续的损害及风险，库仑不承担任何责任。\n" +
                       "6.3  对于不可抗力、计算机病毒、黑客攻击、系统不稳定、用户所在位置、用户关机以及其他任何网络、技术、通信线路等原因造成的服务中断或不能满足用户要求的风险，由用户自行承担，库仑不承担任何责任。\n" +
                       "6.4  对于库仑向用户提供的下列产品或者服务的质量缺陷本身及其引发的任何损失，库仑无需承担任何责任：\n" +
                       "1)\t库仑向用户免费提供的各项服务；\n" +
                       "2)\t库仑向用户赠送的任何产品或者服务；\n" +
                       "3)\t库仑向收费网络服务用户附赠的各种产品或者服务；\n" +
                       "6.5  “库仑能网换电宝”所提供的功能受制于我国的管理条例，即与本产品的功能和条例发生冲突时，应以各地的管理条例为最高准则。任何在使用“库仑能网换电宝”服务过程中直接或间接违反当地管理条例的行为，该后果应由用户承担。如有举证需要，库仑可以向有关部门提供相关数据作为证据。\n" +
                       "7\t知识产权声明\n" +
                       "7.1  库仑在本服务中提供的内容（包括但不限于网页、文字、图片、音频、视频、图表等）的知识产权均归库仑所有，但用户在使用本服务前对自己发布的内容已合法取得知识产权的除外。\n" +
                       "7.2  除另有特别声明外，库仑提供本服务时所依托软件的著作权、专利权及其他知识产权均归库仑所有。\n" +
                       "7.3  库仑在本服务中所涉及的图形、文字或其组成，以及其他库仑标志及产品、服务名称（以下统称“库仑标识”），其著作权或商标权归库仑所有。未经库仑事先书面同意，用户不得将库仑标识以任何方式展示或使用或作其他处理，也不得向他人表明用户有权展示、使用、或其他有权处理库仑标识的行为。\n" +
                       "7.4  上述及其他任何库仑依法拥有的知识产权均受到法律保护，未经库仑书面许可，用户不得以任何形式进行使用或创造相关衍生作品。\n" +
                       "8\t不可抗力及其他免责事由\n" +
                       "8.1  用户理解并确认，在使用本服务的过程中，可能会遇到不可抗力等风险因素，使本服务发生中断。不可抗力是指不能预见、不能克服并不能避免且对一方或双方造成重大影响的客观事件，包括但不限于自然灾害如洪水、地震、瘟疫流行和风暴等以及社会事件如战争、动乱、政府行为等。出现上述情况时，库仑将努力在第一时间与相关单位配合，及时进行修复，但是由此给用户或第三方造成的损失，库仑及合作单位在法律允许的范围内免责。\n" +
                       "8.2  本服务同大多数互联网服务一样，受包括但不限于用户原因、网络服务质量、社会环境等因素的差异影响，可能受到各种安全问题的侵扰，如他人利用用户的资料，造成现实生活中的骚扰；用户应加强信息安全及使用者资料的保护意识，要注意加强密码保护，以免遭致损失和骚扰。\n" +
                       "8.3  用户理解并确认，本服务存在因不可抗力、计算机病毒或黑客攻击、系统不稳定、用户所在位置、用户关机以及其他任何技术、互联网络、通信线路原因等造成的服务中断或不能满足用户要求的风险，因此导致的用户或第三方任何损失，库仑不承担任何责任。\n" +
                       "8.4  用户理解并确认，库仑需要定期或不定期地对“库仑能网换电宝”平台或相关的设备进行检修或者维护，如因此类情况而造成服务在合理时间内的中断，库仑无需为此承担任何责任，但库仑应事先进行通告。\n" +
                       "8.5  库仑对用户承担的全部责任，无论因何原因或何种行为方式，始终不超过用户因使用库仑提供的服务而支付给库仑的费用(如有)。\n" +
                       "9\t服务的变更、中断、终止\n" +
                       "9.1  鉴于网络服务的特殊性，用户同意库仑有权随时变更、中断或终止部分或全部的服务（包括收费服务）。库仑变更、中断或终止的服务，库仑应当在变更、中断或终止之前通知用户，并应向受影响的用户提供等值的替代性的服务；如用户不愿意接受替代性的服务，库仑按实际服务情况扣除相应费用再退还至用户账户。\n" +
                       "9.2  如发生下列任何一种情形，库仑有权变更、中断或终止向用户提供的免费服务或收费服务，而无需对用户或任何第三方承担任何责任：\n" +
                       "(1) 根据法律规定用户应提交真实信息，而用户提供的个人资料不真实、或与注册时信息不一致又未能提供合理证明；\n" +
                       "(2) 用户违反相关法律法规或本协议的约定； \n" +
                       "(3) 按照法律规定或有权机关的要求；\n" +
                       "(4) 出于安全的原因或其他必要的情形。\n" +
                       "10\t法律管辖\n" +
                       "10.1  本协议的订立、执行和解释及争议均受到中华人民共和国法律管辖。\n" +
                       "10.2  如双方就本协议内容或其执行发生任何争议，双方应尽量友好协商解决；协商不成时，任何一方均可向库仑所在地的人民法院提起诉讼。\n" +
                       "11\t其他规定\n" +
                       "11.1  如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，本协议的其余条款仍应有效并且有约束力。\n" +
                       "11.2  本协议中的标题仅为方便而设，在解释本协议时不应受该标题的限制。\n" +
                       "11.3  库仑对该使用协议享有最终解释权。\n";
        binding.textview.setText(message);
    }
}
