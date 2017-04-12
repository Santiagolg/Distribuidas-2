<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Propiedades</h2>
  <table border="1" style="width:100%">



<tr>
  <th rowspan="2">Id</th>
  <th rowspan="2">Tipo</th>
  <th rowspan="2">Precio</th>
  <th colspan="5">Direccion</th>
  <th rowspan="2">Nro.Habitaciones</th>
  <th rowspan="2">Nro.Baños</th>
</tr>
<tr>
    <th>Nro</th>
    <th>Calle</th>
    <th>Barrio</th>
    <th>Localidad</th>
    <th>CP</th>
</tr>
<xsl:apply-templates select="rentalProperties/property"/>

</table>

</body>
</html>
</xsl:template>

<xsl:template match="property">
  <tr>
    <td><span> <xsl:value-of select="@id"/></span></td>
    <td><span><xsl:value-of select="type"/></span></td>
    <td><span><xsl:value-of select="price"/></span></td>
    <td><span><xsl:value-of select="address/streetNo"/></span></td>
    <td><span><xsl:value-of select="address/street"/></span></td>
    <td><span><xsl:value-of select="address/suburb"/></span></td>
    <td><span><xsl:value-of select="address/state"/></span></td>
    <td><span><xsl:value-of select="address/zipcode"/></span></td>
    <td><span><xsl:value-of select="numberOfBedrooms"/></span></td>
    <td><span><xsl:value-of select="numberOfBathrooms"/></span></td>

  </tr>
</xsl:template>





</xsl:stylesheet>
