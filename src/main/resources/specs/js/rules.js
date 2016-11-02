rule("%{objectPattern} inside partly %{objectReference} left", function(objectName, parameters) {

   // Searching for all objects with user-defined pattern
       var allObjects = findAll(parameters.objectPattern);
       var allRefs = findAll(parameters.objectReference);

        if (allObjects.length > 0) {

                for (var i = 0; i < allObjects.length ; i++) {
                    var distance = allObjects[i].left() - allRefs[0].left();
                    if ((allObjects[i].left() - allRefs[0].left()) % 31 == 0) {
                        this.addObjectSpecs(allObjects[i].name,
                        ["inside partly " + allRefs[0].name + " " + distance + " px left"]);
                    } else {
                        throw new Error("Distance is not multiple of 31");
                    }

                }

            } else {
                        throw new Error("Distance is not multiple of 31");
        }
   });