package com.example.electronicsrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private var listOfObject: ArrayList<Product> = ArrayList<Product>()
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var s1 = ArrayList<String>()
    var s2 = ArrayList<Double>()
    var s3 = ArrayList<String>()
    var s4 = ArrayList<String>()
    var s5 = ArrayList<String>()
    var madr: MyAdapter? = null
    var images = ArrayList<String>()

    /*
    var imageges = intArrayOf(
        R.drawable.camera,
        R.drawable.headphone,
        R.drawable.laptop,
        R.drawable.tablet,
        R.drawable.tv
    )
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfObject.add(
            Product(
                "PANASONIC LUMIX FZ80 4K Digital Camera.",
                240.00,
                "Black",
                "camera.jpg",
                "555 263 847",
                "PANASONIC LUMIX FZ80 4K Digital Camera, 18.1 Megapixel Video Camera, 60X Zoom DC VARIO\n" +
                        "20-1200mm Lens, F2.8-5.9 Aperture, POWER O.I.S. Stabilization, Touch Enabled 3-Inch LCD,\n" +
                        "Wi-Fi, DC-FZ80K (Black)"
            )
        )
        listOfObject.add(
            Product(
                "Tribit XFree Tune Bluetooth Headphones.",
                53.40,
                "Black",
                "headphone.jpg",
                "555 263 848",
                "Tribit XFree Tune Bluetooth Headphones Over Ear - Wireless Headphones 40 Hrs Playtime,\n" +
                        "Hi-Fi Stereo Sound with Rich Bass, Built-in Mic, Soft Earmuffs - Foldable Headset with\n" +
                        "Carry Case, Black"
            )
        )
        listOfObject.add(
            Product(
                "HP Chromebook 14-inch Laptop with 180-Degree Hinge.",
                878.15,
                "Gray",
                "laptop.jpg",
                "555 263 849",
                "HP Chromebook 14-inch Laptop with 180-Degree Hinge, AMD Dual-Core A4-9120 Processor, 4GB SDRAM, 32 GB eMMC Storage, Chrome OS (14-db0030nr, Snow White)"
            )
        )
        listOfObject.add(
            Product(
                "Fire 7 Tablet (7\" display, 16 GB) - Black.",
                440.44,
                "Blsck",
                "tablet.jpg",
                "555 263 850",
                "Fire 7 Tablet (7\" display, 16 GB) - Black. 7\" IPS display; 16 or 32 GB of internal\n" +
                        "storage (add up to 512 GB with microSD). Faster 1.3 GHz quad-core processor, Up to 7\n" +
                        "hours of reading, browsing the web, watching video, and listening to music, Now Alexa\n" +
                        "hands-free, 1 GB of RAM, 2 MP front and rear-facing cameras with 720p HD video\n" +
                        "recording, Dual-band Wi-Fi"
            )
        )
        listOfObject.add(
            Product(
                "Samsung UN55RU7100FXZA Flat 55-Inch",
                1230.09,
                "Black",
                "tv.jpg",
                "555 263 851",
                "Samsung UN55RU7100FXZA Flat 55-Inch 4K UHD 7 Series Ultra HD Smart TV with HDR and Alexa Compatibility (2019 Model)"
            )
        )

        r1 = findViewById<RecyclerView>(R.id.rv)
        for (element in listOfObject) {
            s1.add(element.title) //= resources.getStringArray(R.array.title);
            s2.add(element.price) //= resources.getStringArray(R.array.price);
            s3.add(element.color) //= resources.getStringArray(R.array.color);
            s4.add(element.desc) //= resources.getStringArray(R.array.detail)
            s5.add(element.itemid) //= resources.getStringArray(R.array.itemId)
            images.add(element.image)
        }
        madr = MyAdapter(this, s1, s2, images, s3, s4, s5)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr

    }
}