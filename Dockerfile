# Usa la imagen oficial de MongoDB
FROM mongo:latest

# Copia el archivo de inicialización al contenedor
COPY init-mongo.js /docker-entrypoint-initdb.d/

# Configuración adicional, si es necesario
ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=nico123
ENV MONGO_INITDB_DATABASE=logdb


# Exponer el puerto predeterminado de MongoDB
EXPOSE 27017

# Definir el comando de inicio de MongoDB
CMD ["mongod"]