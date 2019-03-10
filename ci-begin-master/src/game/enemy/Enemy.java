package game.enemy;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    ArrayList<EnemyBullet> enemyBullets;

    public Enemy() {
        image = SpriteUtils.loadImage("E:\\Techkid\\nvhoang-CI\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\1.png");
        velocity.set(0, 3);
        enemyBullets = new ArrayList<>();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        for (int i = 0; i < enemyBullets.size(); i++) {
            EnemyBullet enemyBullet = enemyBullets.get(i);
            enemyBullet.render(g);
        }
    }

    @Override
    public void run() {
        super.run();
        changeDirection();
        enemyFire();
        enemyBulletRun();
    }

    int firecount;
    private void enemyFire() {
        firecount++;
        if (firecount>500) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(position);
            enemyBullets.add(enemyBullet);
            firecount = 0;
        }
    }

    private void enemyBulletRun() {
        for (int i = 0 ; i < enemyBullets.size() ; i++){
            EnemyBullet  enemyBullet = enemyBullets.get(i);
            enemyBullet.run();
        }
    }

    private void changeDirection() {
        if(position.x > Settings.BACKGROUND_WIDTH - 28 && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
    }
}
