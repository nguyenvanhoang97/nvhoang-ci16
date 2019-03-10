package game.enemy;

import game.GameObject;
import game.Vector2D;
import game.player.Player;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    int count;

    public EnemyBullet() {
        image = SpriteUtils.loadImage("E:\\Techkid\\nvhoang-CI\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
        velocity.set(0, 5);
        count = 0;
    }

    @Override
    public void run() {
        super.run();
        count++;
        if(count > 120) {
            Player player = GameObject.find(Player.class);
            if(player != null) {
                Vector2D bulletToPlayer = player.position.clone();
                bulletToPlayer.substract(this.position);
                bulletToPlayer.setLength(2);

                this.velocity.set(bulletToPlayer);
            }
        }
    }
}
