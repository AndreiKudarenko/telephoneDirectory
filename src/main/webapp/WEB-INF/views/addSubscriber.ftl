<import "/spring.ftl" as spring/>

       <html>
          <head>
             <title>Add subscriber</title>
          </head>
          <body>
             <div>
                 <legend>Add subscriber</legend>
                    <form method="POST" enctype="multipart/form-data"
                           action="/upload">
                           File to upload: <input type="file" name="file"><br />
                           <input type="submit" value="addSubscriber"> Press here to upload the file!
                    </form>
             </div>
          </body>

       </html>