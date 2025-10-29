package com.example.paticle

import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class ParticlesMove : JavaPlugin() {

    override fun onEnable() {
        logger.info { "particle enabled" }

        object : BukkitRunnable(){
            override fun run() {
                for (player in Bukkit.getOnlinePlayers()){
                    //プレイヤーの足元の座標を取得
                    val location = player.location.clone().add(0.0,0.1,0.0)

                    player.world.spawnParticle(
                        Particle.FLAME, //種類
                        location,       //プレイヤーの座標
                        5,      //パーティクルの個数
                        0.1,0.2,0.1) //パーティクルの広がり
                }
            }
        }.runTaskTimer(this,0L,2L) //1秒 = 20tick 2tick = 0.2秒
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }
}
