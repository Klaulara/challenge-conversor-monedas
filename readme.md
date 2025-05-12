# Conversor de Monedas en Java 💱

Este proyecto es una aplicación de consola en Java que permite convertir montos entre diferentes monedas utilizando tasas de cambio en tiempo real a través de una API externa.

## ✨ Funcionalidades

- Conversión entre las siguientes monedas:
    - Dólar (USD) ⇄ Peso Argentino (ARS)
    - Dólar (USD) ⇄ Real Brasileño (BRL)
    - Dólar (USD) ⇄ Peso Chileno (CLP)
- Interfaz sencilla y amigable por consola.
- Validación de entradas del usuario.
- Llamadas a una API para obtener tasas de conversión actualizadas.

## 🛠️ Tecnologías utilizadas

- Java 17+
- API ([ExchangeRate-API](https://www.exchangerate-api.com/))
- IDE sugerido: IntelliJ IDEA, Eclipse o VSCode con soporte para Java

## 📦 Estructura del proyecto

```
com.alura.conversormonedas/
├── Main.java # Clase principal que maneja el flujo del programa
├── Rate.java #Clase para convertir la respuesta de la API a Java
└── GetRate.java # Clase para conectarse con la API de tasas de cambio
```

## ▶️ Cómo ejecutar el programa

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/conversor-monedas-java.git
    ```
2. Abre el proyecto en tu IDE preferido.
3. Asegúrate de tener configurado tu JDK correctamente (Java 17 o superior).
4. Asegúrate de tener configurado tu .env (sigue el .env.example) esta API requiere de una api key la que debe ser ingresada para poder realizar las conversiones.
5. Ejecuta la clase Main.java 
