package SampleCreator;

import DataController.DataAdder;
import Model.Product;

public class ProductCreator {

	public static void Create() {

		Product P1 = new Product("Samsung Galaxy A71",
				" گوشی موبایل گلکسی A71 سامسونگ یکی از قدرتمندترین محصولات میان‌رده موجود در بازار است که حسگر انگشت زیرصفحه نمایش و دوربین چهار‌گانه روانه بازار شده است ",
				Product.ParseToArray(
						"[[حافظه داخلی ,128 گیگابایت],[شبکه های ارتباطی , 2G/3G/4G],[دوربین‌های پشت گوشی  ,4 ماژول دوربین],[سیستم عامل  ,Android]]"),
				10299000, 20, Product.PHONE, 35, Product.GenerateID());

		Product P2 = new Product("iPhone 12 Pro Max",
				" گوشی موبایل «iPhone 12 Pro MAX» پرچم‌دار جدید شرکت اپل است که با چند ویژگی جدید و دوربین چهارگانه روانه بازار شده است. اپل برای ویژگی‌ها و طراحی کلی این گوشی از همان فرمول چند سال اخیرش استفاده کرده است ",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,iOS]]"),
				39700000, 0, Product.PHONE, 100, Product.GenerateID());

		Product P3 = new Product("HUAWEI P40 Pro",
				" گوشی موبایل « P40 Pro» از محصولات بالارده هوآوی است که به عنوان یک گوشی همه‌چیزتمام روانه بازار شده است تا رقابت بین شرکت های بزرگ سازنده گوشی موبایل در بازار سخت‌تر و جذاب‌تر از همیشه شود. ",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,1 ماژول دوربین],[سیستم عامل : ,Android]]"),
				23453000, 10, Product.PHONE, 50, Product.GenerateID());

		Product P4 = new Product("Samsung Galaxy Note20 Ultra",
				"گوشی موبایل سامسونگ مدل Galaxy Note20 Ultra 5G SM-N986BZKWXSG دو سیم کارت ظرفیت 256 گیگابایت یکی از شگفت‌انگیزترین گوشی‌های کمپانی بزرگ سامسونگ است که با رونمایی آن، همه افرادی که از طرفداران سامسونگ هستند را شگفت‌زده کرده است",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				31599000, 5, Product.PHONE, 90, Product.GenerateID());

		Product P5 = new Product("Samsung Galaxy S21 Ultra",
				"خبری از شیار کارت حافظه نیست. حتی خبری از شارژر در جعبه محصول نیست. شاید این ویژگی‌ها قبل از هر چیز دیگری در زمان دیدن جدول مشخصات گوشی موبایل Galaxy S21 Ultra جلب توجه می‌کنند.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				29000000, 0, Product.PHONE, 10, Product.GenerateID());

		Product P6 = new Product("iPhone 11",
				"گوشی موبایل «iPhone 11» یکی از سه گوشی شرکت اپل است که در کنفرانس سال 2019 این شرکت معرفی شد. این گوشی نسبت به گوشی‌های Pro و Pro Max قیمت پایین‌تری دارد اما طراحی مشابهی با این محصولات دارد",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,2 ماژول دوربین],[سیستم عامل : ,iOS]]"),
				24770000, 7, Product.PHONE, 5, Product.GenerateID());

		Product P7 = new Product("iPhone XS",
				"گوشی همراه «iPhone XS» از سری تولیدات جدید شرکت «اپل» است که در ماه سپتامبر سال 2018 همراه با دو مدل دیگر این شرکت یعنی «iPhone XR»، «iPhone XS Max» رونمایی شد.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,2 ماژول دوربین],[سیستم عامل : ,iOS]]"),
				30000000, 25, Product.PHONE, 100, Product.GenerateID());

		Product P8 = new Product("Samsung Galaxy A51",
				"این نسخه از گوشی موبایل Galaxy A51 با رم 8 گیگابایتی و حافظه داخلی 256 گیگابایت روانه بازار شده است. این محصول دارای صفحه‌نمایش سوپر آمولد است و ظاهر زیبایی دارد. ",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				8999000, 4, Product.PHONE, 57, Product.GenerateID());

		Product P9 = new Product("Samsung Galaxy M51",
				"گوشی موبایل Galaxy M51 از میان رده‌های جدید شرکت سامسونگ است که با طراحی زیبا و سخت‌افزار قوی روانه بازار شده است. سامسونگ تلاش کرده است حاشیه را در این تولید جدید خود تا حد امکان کم کند",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				9749000, 0, Product.PHONE, 60, Product.GenerateID());

		Product P10 = new Product("Samsung Galaxy A52",
				"این نسخه از گوشی موبایل Galaxy A52 با رم 8 گیگابایتی و حافظه داخلی 256 گیگابایت به عنوان یکی از جدیدترین میان‌رده‌های سامسونگ روانه بازار شده است. این محصول دارای صفحه‌نمایش سوپر آمولد است و ظاهر زیبایی دارد.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				9599000, 10, Product.PHONE, 47, Product.GenerateID());

		Product P11 = new Product("ASUS Zenbook UX431FL",
				"لپ‌تاپ «ZenBook UX431FL» از سری محصولات زیبا و شکیل «ایسوس» است که طراحی آن شبیه مدل‌های پیشین ذن‌بوک است. امکانات سخت‌افزاری بسیار خوب و صفحه‌نمایش با دقت تصویر Full-HD از ویژگی‌های چشمگیر این لپ‌تاپ است. ",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,8 گیگابایت],[ظرفیت حافظه داخلی : ,512 گیگابایت],[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,14 اینچ]]"),
				29100000, 1, Product.COMPUTER, 64, Product.GenerateID());

		Product P12 = new Product("ASUS ZenBook UX534FTC",
				"لپ تاپ ایسوس ZenBook UX534FTC یکی از باریک ترین لپ تاپ های زنبوک پرو شرکت ایسوس می باشد که در اخیرا رونمایی شد و یکی از ظریف ترین و سبک ترین لپ تاپ های 15 اینچی حال حاضر بازار می باشد که دارای کارت گرافیک سری GTX می باشد.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,16 گیگابایت],[ظرفیت حافظه داخلی : ,یک ترابایت],[[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,15.6 اینچ]]"),
				49000000, 5, Product.COMPUTER, 87, Product.GenerateID());

		Product P13 = new Product("Microsoft Surface Book 3F",
				"این لپ‌تاپ تبدیل‌پذیر 13.5اینچی یک ترکیب بی‌نظیر از طراحی زیبا و خلاقانه درکنار سخت‌افزارهای قدرتمند است. وضوح تصویری متفاوت برابر با 3000 در 2000 پیکسل نشانگر همیشگی سرفیس بوک‌هاست.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,32 گیگابایت],[ظرفیت حافظه داخلی : , یک ترابایت],[[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,13.5 اینچ]]"),
				99999000, 8, Product.COMPUTER, 15, Product.GenerateID());

		Product P14 = new Product("ASUS ROG M15",
				"ایسوس دوباره با یک لپ‌تاپ دیگر توانست قدمی محکم و بسیار خوب برای اعتبار و قدرت خود در عرصه لپ‌تاپ‌ها بردارد. لپ تاپ 15.6 اینچی ایسوس مدل ROG ZEPHYRUS M15 GU502LW-AZ086 یکی از بهترین‌های لپ‌تاپ در رسته بازی و گرافیک است که می‌تواند با قدرتش شما را حیرت‌زده کند.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,16 گیگابایت],[ظرفیت حافظه داخلی : ,  یک ترابایت],[[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,15.6 اینچ]]"),
				60499000, 9, Product.COMPUTER, 90, Product.GenerateID());

		Product P15 = new Product("Lenovo ThinkPad T490S",
				"سری لپ‌تاپ‌های‌ «ThinkPad‌» لنوو محصولات خوش‌ساخت و بادوامی‌اند که به استحکام و کارایی معروف‌اند. این رده از لپ‌تاپ‌های لنوو از تنوع بسیار خوبی هم برخوردارند و کاربران علاقه‌مند به این مدل می‌توانند بسته‌ به فاکتورهای مختلف، بهترین انتخاب را بکنند.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,16 گیگابایت],[ظرفیت حافظه داخلی : , 512 گیگابایت],[[سازنده پردازنده گرافیکی : ,Intel],[اندازه صفحه نمایش : ,14 اینچ]]"),
				65000000, 0, Product.COMPUTER, 50, Product.GenerateID());

		Product P16 = new Product("ASUS Zbook 15 G5",
				"لپ‌تاپ اچ پی مدل ZBook 15 G5 Mobile Workstation یکی از مدل‌های قدرتمند و در واقع ورک‌استیشن است.صفحه‌نمایش این لپ‌تاپ اندازه 15.6 اینچی با پنل IPS، وضوح تصویر FullHD و روکش مات دارد که هم اندازه مناسب برای جابجایی را داشته و هم کیفیت لازم برای کار کردن در شرایط مختلف را دارد",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,64 گیگابایت],[ظرفیت حافظه داخلی : , یک ترابایت],[[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,15.6 اینچ]]"),
				61790000, 11, Product.COMPUTER, 0, Product.GenerateID());

		Product P17 = new Product("HP OMEN 17",
				"سری لپ‌تاپ‌های Omen شرکت «HP» از محصولات حرفه‌ای این شرکت هستند که سخت‌افزارهای قوی و امکانات متعددی دارند و مخصوص کاربری‌های حرفه‌ای طراحی شده‌اند. یکی از جدیدترین مدل‌های 17 اینچی این سری «CB1097» نام دارد ",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,32 گیگابایت],[ظرفیت حافظه داخلی : , دو ترابایت],[[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,17.3 اینچ]]"),
				59730000, 7, Product.COMPUTER, 0, Product.GenerateID());

		Product P18 = new Product("Desktop Green Z6 Artemis",
				"کامپیوترهای ورک استیشن امروزه یکی از نیازهای اساسی مهندسان و طراحان ۲ بعدی و ۳ بعدی و همه کسانی است که از کامپیوتر فراتر از نیازهای روزمره‌ و اجرای بازی بهره می برند.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,64 گیگابایت],[ظرفیت حافظه داخلی : , یک ترابایت],[[سازنده پردازنده گرافیکی : ,Intel],[نوع حافظه داخلی : ,SSD]]"),
				222222000, 0, Product.COMPUTER, 0, Product.GenerateID());

		Product P19 = new Product("MacBook Pro MVVK2",
				"صفحه کلید کاملا جدید ، صفحه نمایش بزرگتر ، صدای بهتر و عملکرد سریع تر باعث شده است که MacBook Pro 16 اینچی گزینه ای عالی برای کاربران حرفه ای باشد.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,16 گیگابایت],[ظرفیت حافظه داخلی : , یک ترابایت],[[سازنده پردازنده گرافیکی : ,AMD],[اندازه صفحه نمایش : ,16 اینچ]]"),
				75964000, 28, Product.COMPUTER, 10, Product.GenerateID());

		Product P20 = new Product("ACER Nitro 5",
				"لپ تاپ ایسر مدل nitro5-55-70uz از سری لپ تاپ های گیمینگ، طراحی و مهندسی شرکت ایسر و در دسته‌بندی گیمینگ، جزء لپ‌تاپ‌های بالارده محسوب شرکت ایسر قرار می‌گیرد.",
				Product.ParseToArray(
						"[[ظرفیت حافظه RAM : ,16 گیگابایت],[ظرفیت حافظه داخلی : , یک ترابایت و 256 گیگابایت],[[سازنده پردازنده گرافیکی : ,NVIDIA],[اندازه صفحه نمایش : ,15.6 اینچ]]"),
				36250000, 12, Product.COMPUTER, 50, Product.GenerateID());

		Product P21 = new Product("Apple Watch Milanese Loop",
				"ساعت هوشمند اپل سری 6 مدل Milanese Loop 44mm یکی دیگر از شاهکارهای شرکت اپل است که به سلامتی افراد توجه بیش‌ازپیش کرده است.ساعت هوشمند اپل سری 6 مدل Milanese Loop 44mm از ساعت‌های هوشمند زیبای این برند است که با طیف گسترده‌ای از کیس‌ها و بندهای جدید ارائه می‌شود",
				Product.ParseToArray(
						"[[مناسب برای : ,آقایان و خانم‌ها],[صفحه نمایش رنگی : ,بله ],[قابلیت نصب سیم کارت : ,ندارد],[صفحه نمایش لمسی : ,بله]]"),
				27499000, 1, Product.ACCESSORIES, 81, Product.GenerateID());

		Product P22 = new Product("Gaming Set",
				"کیف 50Cal پلاستیکی با کیفیت بالا، تمام سخت افزار را می توان به درستی و با خیال راحت ذخیره کردو به شما اجازه می دهد تا به راحتی به مقصد خود منتقل و حمل کنید! پکیج کامل Epicgear DeFiant 50 CAL gaming case برای ارائه حداکثر تحرک تجهیزات بازی طراحی شده است.",
				Product.ParseToArray(
						"[[همراه با ماوس : ,بله],[نوع اتصال : ,باسیم],[نوع رابط : ,پورت USB],[چراغ‌ پس زمینه صفحه کلید : ,دارد]]"),
				14000000, 50, Product.ACCESSORIES, 46, Product.GenerateID());

		Product P23 = new Product("Hard External",
				"یکی از بهترین و گران ترین هارد اکسترنال های موجود در بازار است که در سال اخیر فروش بسیار زیادی داشته است",
				Product.ParseToArray(
						"[[ظرفیت : ,20 ترابایت],[نوع اتصال : ,باسیم],[نوع رابط : ,Thunderbolt 2],[مقاوم در برابر آب : ,خیر]]"),
				109500000, 25, Product.ACCESSORIES, 55, Product.GenerateID());

		Product P24 = new Product("Printer LaserJet Enterprise",
				"یکی از پر فروش ترین پرینتر های موجود در ایران که از زمان عرضه به بازار بیش از صد میلیون فروش رسیده است",
				Product.ParseToArray("[[نوع چاپ : ,تک رنگ],[اسکنر : ,دارد],[کپی : ,دارد],[فکس : ,دارد]]"), 123060000, 8,
				Product.ACCESSORIES, 55, Product.GenerateID());

		Product P25 = new Product("PlayStation 5",
				"جدید ترین و محبوب ترین محصول شرکن سونی که سال قبل به بازار عرضه شد . این کنسول بازی کیفیت فوق العاده بالایی دارد و از مهمترین قابلیت های آن میتوان به ساپورت گیم های پلی استیشن 4 اشاره کرد",
				Product.ParseToArray("[[تعداد دسته : ,2],[بازی : ,ندارد]]"), 34700730, 0, Product.ACCESSORIES, 64,
				Product.GenerateID());

		Product P26 = new Product("Laptop Bag", "کیف محکم و مقاوم برای لپ تاپ",
				Product.ParseToArray("[[مناسب برای لپ تاپ های : ,15 تا 17 اینچی]]"), 5000000, 0, Product.ACCESSORIES,
				75, Product.GenerateID());

		Product P27 = new Product("ROG Strix Cooler",
				"سری خنک کننده های مایع ROG Strix LC ایسوس،زیبایی و کارایی در کنار یکدیگر باهم دارند. واترکولرهای یکپارچه ایسوس ROG Strix LC بالاترین سطح کارایی را ارائه داده و بدون نگرانی مصرف کنندگان از بابت تعادل دمای پردازنده نگرانی خواهد بود.",
				Product.ParseToArray(
						"[[ : نوع خنک‌ کننده,آبی],[نورپردازی LED : ,دارد],[تعداد لوله‌ها : ,2],[تعداد فن‌ها : ,2]]"),
				7980000, 2, Product.ACCESSORIES, 90, Product.GenerateID());

		Product P28 = new Product("Graphics Card TUF",
				"با قاطعیت می توان گفت قدرتمند ترین کارت گرافیکی موجود در بازار است",
				Product.ParseToArray(
						"[[رابط اتصال : ,PCI Express 4.0],[HDMI : ,2],[فضای نصب مورد نیاز : ,دو اسلات],[نوع حافظه : ,GDDR6X]]"),
				100000000, 9, Product.ACCESSORIES, 46, Product.GenerateID());

		Product P29 = new Product("Philips Monitor",
				"مانیتور مدل BDM4350UC دارای رزولوشن 4K یا Ultra HD است که با 3840  پیکسل افقی و 2160 پیکسل عمودی، تصاویر را طبیعیتر و با جزئیات بیشتری جلوه میدهد. نوع پنل آن IPS است و از تکنولوژی پیشرفتهای استفاده میکند که به شما زاویه دید عریض 178/178 درجه میدهد.",
				Product.ParseToArray(
						"[[بلندگو  : ,دارد],[نوع پنل : ,IPS],[نور پس‌زمینه : ,WLED],[رزولوشن : ,2160 × 3840 پیکسل]]"),
				21200000, 0, Product.ACCESSORIES, 64, Product.GenerateID());

		Product P30 = new Product("Nimbus Wireless Game Controller",
				"استیل سریز یکی از معتبر ترین برند های لوازم جانبی مخصوص بازی میباشد که در اروپا شروع به کار کرده و تمرکز خودش رو بر راحتی و کاربرپسند بودن محصولات خود گذاشته است و محصولات خود را به دست کاربران در سرتاسر جهان رسانده است .",
				Product.ParseToArray("[[نوع اتصال : ,بی‌سیم],[رابط : ,بلوتوث]"), 3990000, 5, Product.ACCESSORIES, 76,
				Product.GenerateID());

		Product P31 = new Product("Milk", "شیر کم چرب میهن",
				Product.ParseToArray("[[طعم : ,ساده],[مناسب برای : ,خانواده]]"), 12600, 0, Product.SUPERMARKET, 88,
				Product.GenerateID());

		Product P32 = new Product("Cheese Powder", "پودر پنیر پارمسان کاله",
				Product.ParseToArray("[[میزان چربی : ,نسبتا چرب],[شکل پنیر : ,رنده شده]]"), 25480, 0,
				Product.SUPERMARKET, 99, Product.GenerateID());

		Product P33 = new Product("Frozen fillele", "فيله منجمد سی بس ايناس",
				Product.ParseToArray("[[نوع : , یخ زده]]"), 148500, 0, Product.SUPERMARKET, 20, Product.GenerateID());

		Product P34 = new Product("Cucumber", "خیار میوری", Product.ParseToArray("[[ارگانیک : ,خیر]]"), 9900, 0,
				Product.SUPERMARKET, 110, Product.GenerateID());

		Product P35 = new Product("Onion", "پياز سفيد ميوري", Product.ParseToArray("[[ارگانیک : ,بله]]"), 11000, 0,
				Product.SUPERMARKET, 120, Product.GenerateID());

		Product P36 = new Product("Carrot", "هويج ميوري", Product.ParseToArray("[[ارگانیک : ,خیر]]"), 9900, 0,
				Product.SUPERMARKET, 220, Product.GenerateID());

		Product P37 = new Product("Banana", "موز درجه یک", Product.ParseToArray("[[ارگانیک : ,خیر]]"), 47000, 0,
				Product.SUPERMARKET, 120, Product.GenerateID());

		Product P38 = new Product("Macaroni", "ماکارونی پیکولی زر ماکارون",
				Product.ParseToArray("[[فرم : ,پیچی],[ارگانیک : ,خیر]]"), 6600, 0, Product.SUPERMARKET, 520,
				Product.GenerateID());

		Product P39 = new Product("Whipped Cream", "پودر خامه کیک و شیرینی پزی کاکائویی",
				Product.ParseToArray("[[تراریخته : ,خیر]]"), 22100, 0, Product.SUPERMARKET, 90, Product.GenerateID());

		Product P40 = new Product("Tomato Paste", "رب گوجه فرنگی بیژن",
				Product.ParseToArray("[[محدوده وزن : ,بیشتر از 500 گرم],[در آسان باز شو : ,دارد]]"), 15400, 0,
				Product.SUPERMARKET, 48, Product.GenerateID());

		Product P41 = new Product("Learn Python", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 110000, 10, Product.BOOK, 41,
				Product.GenerateID());

		Product P42 = new Product("Learn HTML,CSS", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 110000, 7, Product.BOOK, 87,
				Product.GenerateID());

		Product P43 = new Product("Learn C++", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 96000, 9, Product.BOOK, 90,
				Product.GenerateID());

		Product P44 = new Product("Learn Android", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 96000, 10, Product.BOOK, 120,
				Product.GenerateID());

		Product P45 = new Product("Learn Java", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 96000, 0, Product.BOOK, 40,
				Product.GenerateID());

		Product P46 = new Product("Learn PHP", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 96000, 5, Product.BOOK, 30,
				Product.GenerateID());

		Product P47 = new Product("Learn Visual C#", "نرم افزار آموزش شرکت پرند",
				Product.ParseToArray("[[نوع دیسک : ,DVD9],[تعداد دیسک : ,2]]"), 110000, 30, Product.BOOK, 20,
				Product.GenerateID());

		Product P48 = new Product("IELTS English", "نرم افزار آموزش زبان انگلیسی نشر درنا",
				Product.ParseToArray("[[نوع دیسک : ,DVD],[تعداد دیسک : ,4]]"), 115000, 49, Product.BOOK, 1,
				Product.GenerateID());

		Product P49 = new Product("Nosrat English", "بسته آموزش سریع مکالمه زبان انگلیسی نصرت نشر نصرت",
				Product.ParseToArray("[[نوع دیسک : ,DVD],[تعداد دیسک : ,1]]"), 52500, 0, Product.BOOK, 10,
				Product.GenerateID());

		Product P50 = new Product("Rosseta Stone", "آموزش زبان انگلیسی رزتااستون جامع نشر نیاز",
				Product.ParseToArray("[[نوع دیسک : ,DVD],[تعداد دیسک : ,2]]"), 230000, 0, Product.BOOK, 70,
				Product.GenerateID());

		Product P51 = new Product("Nokia 5.4",
				"گوشی موبایل «5.4» از سری محصولات جدید و خوش‌ساختی است که از سوی شرکت مطرح «نوکیا» (Nokia) روانه بازار شده است. صفحه‌نمایش این گوشی موبایل در اندازه 6.39 اینچ است و از فناوری IPS بهره می برد.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				4780000, 20, Product.PHONE, 150, Product.GenerateID());

		Product P52 = new Product("Moto G 5G Plus",
				"گوشی «Moto G 5G Plus» از سری محصولات شرکت مطرح موتورولا است که با پنل LTPS IPS و پشتیبانی از فناوری ارتباطی 5G روانه بازار شده است. نمایشگر Moto G 5G Plus از رزولوشن بالایی برخوردار است",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				8449000, 10, Product.PHONE, 50, Product.GenerateID());

		Product P53 = new Product("Samsung Galaxy Z Fold",
				"گوشی موبایل سامسونگ مدل مدل Galaxy Z Fold2 5G SM-F916B تک سیم‌کارت ظرفیت 256 گیگابایت و رم 12 گیگابایت در ۵ آگوست 2020 به بازار عرضه شد تا تنوع محصولات سامسونگ را هرچه بیشتر کند. این گوشی تاشو طراحی نوینی دارد که آن را به محصولی خاص تبدیل کرده است.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,3 ماژول دوربین],[سیستم عامل : ,Android]]"),
				45900000, 0, Product.PHONE, 100, Product.GenerateID());

		Product P54 = new Product("Galaxy Z Flip",
				"گوشی موبایل «Galaxy Z Flip» در فوریه 2020 به بازار عرضه شد تا تنوع محصولات سامسونگ را هرچه بیشتر کند. این گوشی تاشو طراحی نوینی دارد که آن را به محصولی خاص تبدیل کرده است. نمایشگر این گوشی در زمان باز شدن 6.7 انیچ اندازه دارد",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,2 ماژول دوربین],[سیستم عامل : ,Android]]"),
				18599000, 10, Product.PHONE, 500, Product.GenerateID());

		Product P55 = new Product("iPhone SE",
				"شرکت اپل نسل دوم گوشی SEخود را در 15 آوریل 2020 معرفی کرد. این گوشی با بهره‌گیری از سخت‌افزار آیفون 11 و ابعاد جمع‌وجور به‌عنوان گوشی میان رده شرکت اپل روانه بازار شده است. قاب پشتی و جلویی آیفون SE از شیشه و فریم آن از آلومینیوم ساخته شده است.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,1 ماژول دوربین],[سیستم عامل : ,IOS]]"),
				14189000, 10, Product.PHONE, 2, Product.GenerateID());

		Product P56 = new Product("Redmi Note 9",
				"نسل نهم از گوشی‌های Redmi Note خود را معرفی کرده است. گوشی « Redmi Note 9 » مانند نسخه‌های قبلی این سری از گوشی‌های شیائومی از صفحه‌نمایش بزرگ، باتری پرقدرت، طراحی جذاب دوربین و سخت‌افزار مناسب برای اجرای بازی برخوردار است.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				4235000, 50, Product.PHONE, 9, Product.GenerateID());

		Product P57 = new Product("Nokia TA",
				"گوشی موبایل «7.2» از سری محصولات جدید و خوش‌ساختی است که از سوی شرکت مطرح «نوکیا» (Nokia) روانه بازار شده است. صفحه‌نمایش این گوشی موبایل در اندازه 6.3 اینچ است و از فناوری IPS بهره می برد.",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G],[دوربین‌های پشت گوشی : ,3 ماژول دوربین],[سیستم عامل : ,Android]]"),
				5990000, 10, Product.PHONE, 18, Product.GenerateID());

		Product P58 = new Product("Xiaomi Mi",
				"گوشی «Mi 10» از سری محصولات شرکت مطرح شیائومی است که با پنل سوپرآمولد و پشتیبانی از فناوری ارتباطی 5G روانه بازار شده است. نمایشگر Mi 10 از رزولوشن بالایی برخوردار است",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				21800000, 1, Product.PHONE, 300, Product.GenerateID());

		Product P59 = new Product("Xiaomi Poco",
				"پس از گذشت دو سال از معرفی نسخه اول Pocophone، شرکت شیائومی جانشین آن را با نام « Poco F2 Pro » معرفی کرد. این گوشی از یک صفحه‌نمایش سوپر آمولد با سایز 6.67 اینچ بهره می‌برد. این صفحه‌نمایش قاب جلویی را پوشانده و هیچ بریدگی‌ای در آن دیده نمی‌شود",
				Product.ParseToArray(
						"[[حافظه داخلی : ,128 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,4 ماژول دوربین],[سیستم عامل : ,Android]]"),
				1710000, 2, Product.PHONE, 5, Product.GenerateID());

		Product P60 = new Product("Xiaomi Mi 10T",
				"گوشی موبایل شیائومی مدل Mi 10T PRO 5G M 2007J3SG دو سیم کارت ظرفیت 256 گیگابایت یکی از شگفت‌انگیزترین گوشی‌های کمپانی بزرگ شیائومی است که با رونمایی آن، همه افرادی که از طرفداران شیائومی هستند را شگفت‌زده کرده است",
				Product.ParseToArray(
						"[[حافظه داخلی : ,256 گیگابایت],[شبکه های ارتباطی: , 2G/3G/4G/5G],[دوربین‌های پشت گوشی : ,3 ماژول دوربین],[سیستم عامل : ,Android]]"),
				14359000, 10, Product.PHONE, 300, Product.GenerateID());

		Product P61 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P62 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P63 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P64 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P65 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P66 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P67 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P68 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P69 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P70 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.COMPUTER, amo, Product.GenerateID());

		Product P71 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P72 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P73 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P74 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P75 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P76 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P77 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P78 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P79 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P80 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.ACCESSORIES, amo, Product.GenerateID());

		Product P81 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P82 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P83 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P84 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P85 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P86 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P87 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P88 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P89 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P90 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.SUPERMARKET, amo, Product.GenerateID());

		Product P91 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P92 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P93 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P94 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P95 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P96 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P97 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P98 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P99 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc, Product.BOOK,
				amo, Product.GenerateID());

		Product P100 = new Product("", " ", Product.ParseToArray("[[d,v],[d,v],[d,v],[d,v]]"), price, perc,
				Product.BOOK, amo, Product.GenerateID());

		DataAdder.AddProduct(P1);
		DataAdder.AddProduct(P2);
		DataAdder.AddProduct(P3);
		DataAdder.AddProduct(P4);
		DataAdder.AddProduct(P5);
		DataAdder.AddProduct(P6);
		DataAdder.AddProduct(P7);
		DataAdder.AddProduct(P8);
		DataAdder.AddProduct(P9);
		DataAdder.AddProduct(P10);
		DataAdder.AddProduct(P11);
		DataAdder.AddProduct(P12);
		DataAdder.AddProduct(P13);
		DataAdder.AddProduct(P14);
		DataAdder.AddProduct(P15);
		DataAdder.AddProduct(P16);
		DataAdder.AddProduct(P17);
		DataAdder.AddProduct(P18);
		DataAdder.AddProduct(P19);
		DataAdder.AddProduct(P20);
		DataAdder.AddProduct(P21);
		DataAdder.AddProduct(P22);
		DataAdder.AddProduct(P23);
		DataAdder.AddProduct(P24);
		DataAdder.AddProduct(P25);
		DataAdder.AddProduct(P26);
		DataAdder.AddProduct(P27);
		DataAdder.AddProduct(P28);
		DataAdder.AddProduct(P29);
		DataAdder.AddProduct(P30);
		DataAdder.AddProduct(P31);
		DataAdder.AddProduct(P32);
		DataAdder.AddProduct(P33);
		DataAdder.AddProduct(P34);
		DataAdder.AddProduct(P35);
		DataAdder.AddProduct(P36);
		DataAdder.AddProduct(P37);
		DataAdder.AddProduct(P38);
		DataAdder.AddProduct(P39);
		DataAdder.AddProduct(P40);
		DataAdder.AddProduct(P41);
		DataAdder.AddProduct(P42);
		DataAdder.AddProduct(P43);
		DataAdder.AddProduct(P44);
		DataAdder.AddProduct(P45);
		DataAdder.AddProduct(P46);
		DataAdder.AddProduct(P47);
		DataAdder.AddProduct(P48);
		DataAdder.AddProduct(P49);
		DataAdder.AddProduct(P50);
	}
}
