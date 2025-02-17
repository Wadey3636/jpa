import os
import pathlib

def add_import(imports):
    with open(dir, "w") as new_file:
        if original_text != content:
            package_index = original_text.find('package')
            line_end_index = original_text.find('\n', package_index)

            modified_text = content[:line_end_index] + '\nimport ' + imports

            if name.endswith(".java"):
                modified_text += ";"
            modified_text += "\n" + content[line_end_index:]
            new_file.write(modified_text)
        else:
            new_file.write(content)


input("MAKE SURE YOU HAVE MADE A BACKUP OF YOUR PROJECT BEFORE RUNNING THIS SCRIPT (press enter to continue)\n")

try:
    os.chdir('src')
except FileNotFoundError:
    input('Please put this script next to the src/ directory! (press enter to exit)')
    exit()

for path, _, files in os.walk("../../../Downloads"):
    for name in files:
        dir = str(pathlib.PurePath(path, name))
        if not (name.endswith(".java") or name.endswith(".kt")):
            continue

        with open(dir,"r+") as f:
            new_f = f.readlines()
            f.seek(0)
            for line in new_f:
                if "import org.polyfrost.oneconfig.config.core.PolyColor" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.config.core.PolyColor", "org.polyfrost.polyui.color.PolyColor"))
                elif "import org.polyfrost.oneconfig.config.core.OneKeyBind" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.config.core.OneKeyBind", "org.polyfrost.polyui.input.Keybinder.Bind"))
                if "import org.polyfrost.oneconfig.config" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.config", "org.polyfrost.oneconfig.api.config.v1"))
                elif "import org.polyfrost.oneconfig.utils.commands.annotations" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.utils.commands.annotations", "org.polyfrost.oneconfig.api.commands.v1.factories.annotated"))
                elif "import org.polyfrost.oneconfig.utils.commands" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.utils.commands", "org.polyfrost.oneconfig.api.commands.v1"))
                elif "import org.polyfrost.oneconfig.utils.hypixel" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.utils.hypixel", "org.polyfrost.oneconfig.api.hypixel.v1"))
                elif "import org.polyfrost.oneconfig.utils.Notifications" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.utils.Notifications", "org.polyfrost.oneconfig.api.ui.v1.notifications.Notifications"))
                elif "import org.polyfrost.oneconfig.utils" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.utils", "org.polyfrost.oneconfig.utils.v1"))
                elif "import org.polyfrost.oneconfig.platform" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.platform", "org.polyfrost.oneconfig.api.platform.v1"))
                elif "import org.polyfrost.oneconfig.api.event.v1.events.event" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.api.event.v1.events", "org.polyfrost.oneconfig.api.event.v1.events"))
                elif "import org.polyfrost.oneconfig.api.event.v1.events" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.api.event.v1.events", "org.polyfrost.oneconfig.api.event.v1"))
                elif "import org.polyfrost.oneconfig.libs.universal" in line:
                    f.write(line.replace("org.polyfrost.oneconfig.libs.universal", "org.polyfrost.universal"))
                elif "import org.polyfrost" in line:
                    f.write(line.replace("org.polyfrost", "org.polyfrost"))
                else:
                    f.write(line)

            f.truncate()

input("Finished removing OneConfig V0 imports.\n\nPress enter to start replacing V0 methods.\n")

for path, _, files in os.walk("../../../Downloads"):
    for name in files:
        dir = str(pathlib.PurePath(path, name))
        if not (name.endswith(".java") or name.endswith(".kt")):
            continue

        with open(dir, "r") as file:
            original_text = file.read()
        with open(dir, "r+") as file:
            content = file.read().replace("TickDelay", "EventDelay.ticks").replace("tick(", "EventDelay.ticks(").replace("RenderTickDelay", "EventDelay.render").replace("renderTick(", "EventDelay.render(")
        add_import("org.polyfrost.oneconfig.api.event.v1.EventDelay")

        with open(dir, "r") as file:
            original_text = file.read()
        with open(dir, "r+") as file:
            content = file.read().replace("PolyColor", "PolyColor")

        with open(dir, "r") as file:
            original_text = file.read()
        with open(dir, "r+") as file:
            content = file.read().replace("OneKeyBind", "Keybinder.Bind")

input("Done! (press enter to exit)")