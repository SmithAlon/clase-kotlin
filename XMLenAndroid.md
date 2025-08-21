# XML para Android Development

## Índice de XML en Android
- [Layouts en Android](#layouts-en-android)
- [Recursos XML](#recursos-xml)
- [Componentes UI](#componentes-ui)
- [Mejores Prácticas](#mejores-prácticas-android)
- [Temas y Estilos](#temas-y-estilos)

## Layouts en Android

### Tipos de Layouts Principales
```xml
<!-- LinearLayout: organiza elementos en una línea horizontal o vertical -->
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">
    
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Ejemplo LinearLayout"/>
        
</LinearLayout>

<!-- RelativeLayout: posiciona elementos en relación a otros -->
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="Botón Centrado"/>
        
</RelativeLayout>

<!-- ConstraintLayout: layout flexible y plano -->
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <TextView
        android:id="@+id/text1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        android:text="Texto con Constraints"/>
        
</androidx.constraintlayout.widget.ConstraintLayout>
```

### Atributos Comunes
```xml
<!-- Dimensiones -->
android:layout_width="match_parent"    <!-- Ancho total del padre -->
android:layout_width="wrap_content"    <!-- Ajustado al contenido -->
android:layout_height="200dp"          <!-- Altura específica -->

<!-- Márgenes y Padding -->
android:layout_margin="16dp"           <!-- Margen en todos los lados -->
android:padding="8dp"                  <!-- Padding interno -->

<!-- Visibilidad -->
android:visibility="visible"           <!-- visible/invisible/gone -->

<!-- ID para referenciar -->
android:id="@+id/mi_elemento"
```

## Recursos XML

### Strings (res/values/strings.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Mi Aplicación</string>
    <string name="welcome_message">Bienvenido</string>
    <string name="hello_user">Hola, %1$s!</string>
</resources>
```

### Colores (res/values/colors.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="primary">#FF6200EE</color>
    <color name="secondary">#FF03DAC5</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
</resources>
```

### Dimensiones (res/values/dimens.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <dimen name="activity_margin">16dp</dimen>
    <dimen name="text_size_large">20sp</dimen>
    <dimen name="button_height">48dp</dimen>
</resources>
```

## Componentes UI

### Botones y Textos
```xml
<!-- Botón básico -->
<Button
    android:id="@+id/btn_login"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/login"
    android:textColor="@color/white"
    android:background="@drawable/button_background"/>

<!-- Campo de texto -->
<EditText
    android:id="@+id/et_username"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="@string/enter_username"
    android:inputType="text"/>

<!-- Texto con estilo -->
<TextView
    android:id="@+id/tv_title"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/title"
    android:textSize="@dimen/text_size_large"
    android:textStyle="bold"/>
```

### RecyclerView y ListView
```xml
<!-- RecyclerView -->
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/recycler_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:scrollbars="vertical"/>

<!-- Item del RecyclerView -->
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp">
    
    <TextView
        android:id="@+id/item_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
        
</LinearLayout>
```

## Mejores Prácticas Android

### Estructura de Archivos
```
res/
├── layout/
│   ├── activity_main.xml
│   ├── fragment_home.xml
│   └── item_list.xml
├── values/
│   ├── strings.xml
│   ├── colors.xml
│   ├── styles.xml
│   └── dimens.xml
└── drawable/
    ├── button_background.xml
    └── ic_launcher.xml
```

### Convenciones de Nombres
```xml
<!-- Layouts -->
activity_*.xml    <!-- Para Activities -->
fragment_*.xml    <!-- Para Fragments -->
item_*.xml        <!-- Para items de listas -->

<!-- IDs -->
<Button android:id="@+id/btn_login"/>      <!-- Botones -->
<TextView android:id="@+id/tv_username"/>   <!-- TextViews -->
<EditText android:id="@+id/et_password"/>   <!-- EditTexts -->
```

## Temas y Estilos

### Definición de Estilos (res/values/styles.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Estilo base para botones -->
    <style name="AppButton" parent="Widget.MaterialComponents.Button">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">56dp</item>
        <item name="android:textSize">16sp</item>
        <item name="android:textAllCaps">false</item>
    </style>

    <!-- Estilo para textos -->
    <style name="TextHeader">
        <item name="android:textSize">24sp</item>
        <item name="android:textStyle">bold</item>
        <item name="android:textColor">@color/primary</item>
    </style>
</resources>
```

### Temas (res/values/themes.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Tema base para la aplicación -->
    <style name="Theme.MyApp" parent="Theme.MaterialComponents.DayNight">
        <!-- Colores primarios -->
        <item name="colorPrimary">@color/primary</item>
        <item name="colorPrimaryVariant">@color/primary_variant</item>
        <item name="colorOnPrimary">@color/white</item>
        
        <!-- Colores secundarios -->
        <item name="colorSecondary">@color/secondary</item>
        <item name="colorSecondaryVariant">@color/secondary_variant</item>
        <item name="colorOnSecondary">@color/black</item>
        
        <!-- Estado de la barra de sistema -->
        <item name="android:statusBarColor">?attr/colorPrimaryVariant</item>
    </style>
</resources>
```

### Uso de Estilos en Layouts
```xml
<Button
    style="@style/AppButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="@string/submit"/>

<TextView
    style="@style/TextHeader"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/welcome"/>
```

### Drawable XML
```xml
<!-- res/drawable/button_background.xml -->
<?xml version="1.0" encoding="utf-8"?>
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
    android:color="?attr/colorControlHighlight">
    <item>
        <shape android:shape="rectangle">
            <corners android:radius="8dp"/>
            <solid android:color="@color/primary"/>
        </shape>
    </item>
</ripple>
```

## Tips para Optimización

### Performance
1. Usar ConstraintLayout para layouts complejos
2. Evitar layouts anidados innecesarios
3. Usar merge cuando sea posible
4. Usar include para reutilizar layouts

### Mantenibilidad
1. Extraer dimensiones a dimens.xml
2. Extraer strings a strings.xml
3. Usar estilos para elementos repetitivos
4. Mantener una jerarquía de layouts plana

### Accesibilidad
```xml
<ImageView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:contentDescription="@string/profile_picture_description"/>

<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/submit"
    android:importantForAccessibility="yes"/>
```
