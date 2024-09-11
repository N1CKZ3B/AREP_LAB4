// init-mongo.js
db = db.getSiblingDB('logdb');
db.createCollection('logs');
