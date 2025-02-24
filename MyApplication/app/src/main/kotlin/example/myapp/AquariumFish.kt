package example.myapp.example.myapp

import android.app.Notification.Action

interface FishAction {
    fun eat(){
    }
}

interface FishColor {
    val color: String
}
class Shark: FishColor, FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}
object GoldColor : FishColor{
    override val color = "gold"
}

class PrintingFishAction(val food: String): FishAction{
    override fun eat() {
        println(food)
    }
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//class Plecostomus: FishAction, FishColor by GoldColor{
//    override fun eat() {
//        println("eat algae")
//    }
//}




