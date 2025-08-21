# Guía Completa de XML: De 0 a Héroe

## Índice
- [Introducción a XML](#introducción-a-xml)
- [Conceptos Básicos](#conceptos-básicos)
- [Estructura de un Documento XML](#estructura-de-un-documento-xml)
- [Elementos y Atributos](#elementos-y-atributos)
- [Validación de Documentos XML](#validación-de-documentos-xml)
- [Espacios de Nombres (Namespaces)](#espacios-de-nombres-namespaces)
- [Procesamiento de XML](#procesamiento-de-xml)
- [XML en la Práctica](#xml-en-la-práctica)
- [Temas Avanzados](#temas-avanzados)
- [Recursos Adicionales](#recursos-adicionales)

## Introducción a XML

### ¿Qué es XML?
XML (eXtensible Markup Language) es un lenguaje de marcado que define reglas para codificar documentos en un formato que sea tanto legible por humanos como por máquinas. Fue diseñado para almacenar y transportar datos, no para mostrarlos.

### Historia y Origen
- Desarrollado por el W3C (World Wide Web Consortium)
- Publicado como recomendación en 1998
- Diseñado para simplificar SGML manteniendo su potencia

### ¿Por qué XML?
- Independiente de la plataforma
- Autodescriptivo
- Separación de datos y presentación
- Soporte para Unicode
- Estructura jerárquica para representar datos complejos

### XML vs HTML
| XML | HTML |
|-----|------|
| Diseñado para transportar datos | Diseñado para mostrar datos |
| Las etiquetas no están predefinidas | Etiquetas predefinidas |
| Debe estar "bien formado" | Más permisivo con errores |
| Distingue entre mayúsculas y minúsculas | No distingue entre mayúsculas y minúsculas |

## Conceptos Básicos

### Sintaxis Básica
```xml
<?xml version="1.0" encoding="UTF-8"?>
<mensaje>
    <para>Juan</para>
    <de>María</de>
    <titulo>Recordatorio</titulo>
    <cuerpo>¡No olvides nuestra reunión mañana!</cuerpo>
</mensaje>
```

### Reglas Sintácticas Esenciales
1. Todo documento XML debe tener un elemento raíz
2. Todas las etiquetas deben tener una etiqueta de cierre
3. Las etiquetas son sensibles a mayúsculas/minúsculas
4. Las etiquetas deben estar correctamente anidadas
5. Los valores de los atributos deben estar entre comillas

### Comentarios en XML
```xml
<!-- Esto es un comentario en XML -->
```

## Estructura de un Documento XML

### Prólogo
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
```
- `version`: Versión de XML
- `encoding`: Codificación de caracteres
- `standalone`: Indica si el documento depende de definiciones externas

### Declaración de Tipo de Documento (DTD)
```xml
<!DOCTYPE mensaje SYSTEM "mensaje.dtd">
```

### Elemento Raíz
Todo documento XML debe tener exactamente un elemento raíz que contenga todos los demás elementos.

### Elementos y Jerarquía
Los elementos pueden contener:
- Otros elementos
- Texto
- Atributos
- Una combinación de los anteriores

## Elementos y Atributos

### Elementos
```xml
<libro>
    <titulo>El Quijote</titulo>
    <autor>Miguel de Cervantes</autor>
</libro>
```

#### Elementos Vacíos
```xml
<imagen src="foto.jpg" />
<!-- Equivalente a: <imagen src="foto.jpg"></imagen> -->
```

### Atributos
```xml
<persona id="1" categoria="cliente">
    <nombre>Ana García</nombre>
    <edad>32</edad>
</persona>
```

### ¿Cuándo usar Elementos vs Atributos?
- **Elementos**: Datos principales, contenido estructurado, información que puede repetirse
- **Atributos**: Metadatos, identificadores, información adicional sobre el elemento

### Entidades
Las entidades permiten incluir caracteres especiales:
- `&lt;` para <
- `&gt;` para >
- `&amp;` para &
- `&quot;` para "
- `&apos;` para '

```xml
<texto>El símbolo &lt; representa "menor que" en matemáticas</texto>
```

## Validación de Documentos XML

### Documento "Bien Formado" vs "Válido"
- **Bien formado**: Sigue las reglas sintácticas de XML
- **Válido**: Además de estar bien formado, cumple con una estructura definida (DTD o XSD)

### DTD (Document Type Definition)
```xml
<!DOCTYPE inventario [
  <!ELEMENT inventario (producto+)>
  <!ELEMENT producto (nombre, precio, cantidad)>
  <!ELEMENT nombre (#PCDATA)>
  <!ELEMENT precio (#PCDATA)>
  <!ELEMENT cantidad (#PCDATA)>
  <!ATTLIST producto id ID #REQUIRED>
]>
```

#### Ejemplo de documento con DTD interno
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE inventario [
  <!ELEMENT inventario (producto+)>
  <!ELEMENT producto (nombre, precio, cantidad)>
  <!ELEMENT nombre (#PCDATA)>
  <!ELEMENT precio (#PCDATA)>
  <!ELEMENT cantidad (#PCDATA)>
  <!ATTLIST producto id ID #REQUIRED>
]>
<inventario>
  <producto id="p1">
    <nombre>Laptop</nombre>
    <precio>999.99</precio>
    <cantidad>10</cantidad>
  </producto>
</inventario>
```

### XSD (XML Schema Definition)
XSD es más potente y expresivo que DTD:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="inventario">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="producto" maxOccurs="unbounded">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="nombre" type="xs:string"/>
              <xs:element name="precio" type="xs:decimal"/>
              <xs:element name="cantidad" type="xs:integer"/>
            </xs:sequence>
            <xs:attribute name="id" type="xs:ID" use="required"/>
          </xs:complexType>
        </xs:element>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
```

#### Ventajas de XSD sobre DTD
- Basado en sintaxis XML
- Soporte para tipos de datos
- Espacios de nombres
- Expresiones regulares
- Herencia de tipos
- Mayor precisión en la validación

## Espacios de Nombres (Namespaces)

### Definición y Propósito
Los espacios de nombres evitan conflictos entre elementos con el mismo nombre pero diferente significado.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<documento xmlns:html="http://www.w3.org/1999/xhtml"
           xmlns:math="http://www.w3.org/1998/Math/MathML">
  <html:p>Esto es un párrafo HTML</html:p>
  <math:formula>
    <math:apply>
      <math:plus/>
      <math:ci>x</math:ci>
      <math:cn>3</math:cn>
    </math:apply>
  </math:formula>
</documento>
```

### Espacio de Nombres por Defecto
```xml
<documento xmlns="http://www.ejemplo.org/ns/documento">
  <titulo>Documento con namespace por defecto</titulo>
</documento>
```

## Procesamiento de XML

### Parsing de XML
Existen dos enfoques principales:
1. **DOM (Document Object Model)**:
   - Carga todo el documento en memoria
   - Permite navegación y modificación completa
   - Mayor consumo de recursos

2. **SAX (Simple API for XML)**:
   - Procesamiento secuencial (evento por evento)
   - No carga todo en memoria
   - Eficiente para documentos grandes
   - Solo lectura (no permite modificación)

### Transformaciones con XSLT
XSLT (eXtensible Stylesheet Language Transformations) permite transformar XML a otros formatos:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h2>Inventario</h2>
        <table border="1">
          <tr>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
          </tr>
          <xsl:for-each select="inventario/producto">
            <tr>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="precio"/></td>
              <td><xsl:value-of select="cantidad"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

### XPath
XPath es un lenguaje para navegar por documentos XML:

```xpath
/inventario/producto[precio > 500]/nombre
```

Este ejemplo selecciona los nombres de todos los productos con precio mayor a 500.

## XML en la Práctica

### XML en Servicios Web
- **SOAP** (Simple Object Access Protocol)
- **WSDL** (Web Services Description Language)
- **RSS/Atom** (formatos de sindicación)

### XML en Configuraciones
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuracion>
  <base-datos>
    <servidor>localhost</servidor>
    <puerto>3306</puerto>
    <nombre>aplicacion_db</nombre>
    <usuario>admin</usuario>
    <contrasena>******</contrasena>
  </base-datos>
  <conexiones-maximas>100</conexiones-maximas>
  <modo-depuracion>true</modo-depuracion>
</configuracion>
```

### Formatos Derivados de XML
- **SVG**: Gráficos vectoriales
- **MathML**: Fórmulas matemáticas
- **KML**: Representación geográfica (Google Earth)
- **XHTML**: HTML reformulado como XML
- **DocBook**: Documentación técnica
- **EPUB**: Libros digitales

## Temas Avanzados

### XML y Bases de Datos
- Almacenamiento de XML en columnas específicas
- Bases de datos nativas XML (eXist, BaseX)
- Consultas con XQuery

### XQuery
```xquery
for $p in doc("inventario.xml")/inventario/producto
where $p/precio > 500
order by $p/precio descending
return 
  <producto_premium>
    <nombre>{$p/nombre/text()}</nombre>
    <precio>{$p/precio/text()}</precio>
  </producto_premium>
```

### XML y JSON
Comparativa y conversión entre formatos:

**XML**:
```xml
<persona>
  <nombre>Juan</nombre>
  <edad>30</edad>
  <direccion>
    <calle>Gran Vía</calle>
    <ciudad>Madrid</ciudad>
  </direccion>
</persona>
```

**JSON** equivalente:
```json
{
  "persona": {
    "nombre": "Juan",
    "edad": 30,
    "direccion": {
      "calle": "Gran Vía",
      "ciudad": "Madrid"
    }
  }
}
```

### Seguridad en XML
- **XML Signature**: Para firmar documentos XML
- **XML Encryption**: Para cifrar documentos XML
- Ataques de inyección XML
- XXE (XML External Entity) vulnerabilidades

## Recursos Adicionales

### Herramientas
- **Editores**: XMLSpy, Oxygen XML Editor, Visual Studio Code con extensiones XML
- **Validadores**: xmllint, online validators
- **Procesadores**: Saxon (XSLT/XQuery), Xerces (parsers)

### Referencias y Documentación
- [W3C XML Specification](https://www.w3.org/XML/)
- [W3Schools XML Tutorial](https://www.w3schools.com/xml/)
- [MDN Web Docs XML Introduction](https://developer.mozilla.org/en-US/docs/Web/XML/XML_introduction)

### Libros Recomendados
- "XML: Visual QuickStart Guide" por Kevin Howard Goldberg
- "Beginning XML" por Joe Fawcett, Liam Quin, y Danny Ayers
- "XML: A Beginner's Guide" por Steven Holzner

### Comunidades y Foros
- Stack Overflow (etiquetas: xml, xslt, xpath, xquery)
- GitHub (proyectos relacionados con procesamiento XML)
- Foros W3C

## Ejercicios Prácticos

### Ejercicio 1: Crear un documento XML
Crea un documento XML que represente una biblioteca con libros, incluyendo título, autor, año de publicación y género.

### Ejercicio 2: Validación con DTD
Crea un DTD para el documento de biblioteca y valida que tu documento cumpla con él.

### Ejercicio 3: Transformación con XSLT
Crea una hoja de estilo XSLT que transforme tu biblioteca XML en una página HTML que muestre los libros en una tabla.

### Ejercicio 4: Consultas con XPath
Escribe expresiones XPath para:
- Seleccionar todos los libros publicados después del año 2000
- Encontrar todos los libros de un autor específico
- Obtener el título del libro más antiguo

---

¡Felicidades! Has completado la guía de XML de 0 a héroe. Ahora tienes los conocimientos necesarios para trabajar con XML en diversos contextos y aplicaciones.
